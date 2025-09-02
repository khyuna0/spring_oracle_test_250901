package com.gyojincompany.oracle.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MemberDto {
	private int membernum; // (자동증가)
	private String memberid; // pk
	private String memberpw;
	private String membername;
	private String memberdate;
	
	// 1:n 관계 ( 한 글쓴이가 글 여러개 )
	private List<BoardDto> boardDtos;
}
