package com.gyojincompany.oracle.dao;

import java.util.List;

import com.gyojincompany.oracle.dto.BoardDto;

public interface BoardDao {
	
	// 게시판 글쓰기
	public void boardWriteDao(String btitle,String bcontent,String bwriter);
	
	// 게시판 글 목록 보기 
	public List<BoardDto> boardListDao();
	
	// 게시판 전체 글 개수
	public int AllBoardCountDao();
	
	// 게시판 글 삭제
	public int boardDeleteDao(int bnum);
	
	// 게시판에서 선택한 글 보기
	public BoardDto boardViewDao(int bnum);
	
	// 글 조회수
	public void boardHitDao(int bnum);
	
	// 글 수정
	public void boardModifyDao(int bnum,String btitle,String bcontent);
}
