package com.gyojincompany.oracle.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.oracle.dao.MemberDao;
import com.mysql.cj.Session;

@Controller
public class MemberController {
		
	@Autowired
	private SqlSession sqlSession;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "memberjoin";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model ) {
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		String mname = request.getParameter("membername");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int checkFlag = dao.memberidCheckDao(mid); // 아이디 중복 체크
		System.out.println("checkFlag : " + checkFlag);
		if(checkFlag != 0 ) { // 가입하려는 아이디가 이미 존재함 
			model.addAttribute("msg", "이미 가입된 아이디입니다. 다시 입력해 주세요");
			model.addAttribute("url", "join");
			return "alert/alert";
			
		} else {
			int result = dao.memberJoinDao(mid, mpw, mname);
			System.out.println(result); // 가입 성공 여부 : 1이면 성공
			
			model.addAttribute("name", mid);
			return "memberjoinOk";	
		}

	}
	
	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, Model model ) {
		
		String error = request.getParameter("error");
		if (error != null) {
			
		}
		
		return "login";
	}
	
	@RequestMapping(value = "/loginOk")
	public String loginOk(HttpServletRequest request, Model model, HttpSession session ) {
		
		String mid = request.getParameter("memberid");
		String mpw = request.getParameter("memberpw");
		
		MemberDao dao = sqlSession.getMapper(MemberDao.class);
		
		int checkFlag = dao.memberLoginDao(mid,mpw); // 아이디 중복 체크
		System.out.println("checkFlag : " + checkFlag);
		
		if(checkFlag != 0 ) { // 로그인 성공
			session.setAttribute("sessionId", mid);
			
			model.addAttribute("msg", "로그인 성공!");
			model.addAttribute("url", "loginSuccess");
			
			return "alert/alert";
			
		} else {
			
			model.addAttribute("msg", "로그인 실패!");
			model.addAttribute("url", "login");
			
			return "alert/alert";
		}

	}
	
	@RequestMapping(value = "/loginSuccess")
	public String loginSuccess() {
		
		return "loginSuccess";
	}
	
	@RequestMapping(value = "/logout")
	public String logout(HttpServletRequest request, Model model, HttpSession session) {
		
		session.invalidate();
		return "login";
	}
}
