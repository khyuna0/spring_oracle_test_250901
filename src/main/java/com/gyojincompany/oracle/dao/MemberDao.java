package com.gyojincompany.oracle.dao;

public interface MemberDao {
	// 회원가입
	public int memberJoinDao(String memberid, String memberpw, String membername);
	
	// 아이디 존재 여부 확인 메서드
	public int memberidCheckDao(String memberid);
	
	// 로그인
	public int memberLoginDao(String memberid, String memberpw);
	
}	
