package com.gyojincompany.oracle.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gyojincompany.oracle.dao.BoardDao;
import com.gyojincompany.oracle.dto.BoardDto;

@Controller
public class BoardController {

	@Autowired
	private SqlSession session;
	
	@RequestMapping(value = "/bwrite")
	public String bwrite(HttpServletRequest request, Model model, HttpSession session) {
		
		String sid = (String) session.getAttribute("sessionId");
		if(sid == null) {
			model.addAttribute("msg", "로그인한 회원만 글쓰기가 가능합니다.");
			model.addAttribute("url", "login");
			return "alert/alert";
		} else {
			return "writeForm";
		}
		
	}
		
	@RequestMapping(value = "/bwriteOk")
	public String bwriteOk(HttpServletRequest request, Model model) {
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		String bwriter = request.getParameter("bwriter");
		
		BoardDao boardDao = session.getMapper(BoardDao.class);
		boardDao.boardWriteDao(btitle, bcontent, bwriter);
		
		return "redirect:blist";
	}
	
//	@RequestMapping(value = "/blist")
//	public String blist(Model model) {
//		BoardDao boardDao = session.getMapper(BoardDao.class);
//		List<BoardDto> boardDtos = boardDao.boardListDao(); // 모든 글 가져오기
//		
//		model.addAttribute("count", boardDao.AllBoardCountDao());
//		model.addAttribute("boardDtos", boardDtos);
//		
//		return "boardlist";
//	}
	
	@RequestMapping(value = "/boardDelete")
	public String boardDelete(HttpServletRequest request, Model model, HttpSession session) {
		
		BoardDao boardDao = this.session.getMapper(BoardDao.class);
		int result = boardDao.boardDeleteDao(Integer.parseInt(request.getParameter("bnum")));
		if(result == 1) { // 글 삭제 성공
			return "redirect:blist";
		} else {
			model.addAttribute("msg", "글 삭제에 실패했습니다.");
			model.addAttribute("url", "blist");
			return "alert/alert";
		}

	}
	
	@RequestMapping(value = "/boardView")
	public String boardView(HttpServletRequest request, Model model, HttpSession session) {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		
		BoardDao boardDao = this.session.getMapper(BoardDao.class);
		boardDao.boardHitDao(bnum);
		model.addAttribute("boardDto", boardDao.boardViewDao(bnum));
		
		return "boardView";
	}
	
	@RequestMapping(value = "/boardModify")
	public String boardModify(HttpServletRequest request, Model model, HttpSession session) {
		int bnum = Integer.parseInt(request.getParameter("bnum"));
		String btitle = request.getParameter("btitle");
		String bcontent = request.getParameter("bcontent");
		
		BoardDao boardDao = this.session.getMapper(BoardDao.class);
		boardDao.boardModifyDao(bnum, btitle, bcontent);
		
		return "redirect:boardView?bnum="+ bnum ;
	}
	
	@RequestMapping(value = "/pagelist")
	public String pagelist(HttpServletRequest request, Model model, HttpSession session) {
		
		int pageSize = 10; // 한 페이지 당 출력될 글 수
		int pageNum = 1; // 유저가 선택한 페이지의 번호(기본값은 1) , 현재 페이지 번호
		int blockSize = 5; // ㅠㅔ이지 블럭에 표시될 페이지의 수 (1 2 3 4 5 / 6 7 8 9 10 ...)
		
		if(request.getParameter("pageNum") != null ) {
			pageNum = Integer.parseInt(request.getParameter("pageNum")); // 유저가 선택한 페이지의 번호
		} 
		
		int startRow = (pageNum * pageSize) - 9; // 페이징 시작시 행의 번호 ( 1-1 / 2-11 / 3-21 ...)
		// (pageNum - 1) * pageSize + 1
		int endRow = pageNum * pageSize;
		
		BoardDao boardDao = this.session.getMapper(BoardDao.class);
		List<BoardDto> boardDtos = boardDao.boardListDao(startRow , endRow); // 모든 글 가져오기
		
		model.addAttribute("count", boardDao.AllBoardCountDao());
		model.addAttribute("boardDtos", boardDtos);
		
		return "pagelist";
	}
	
	
}
