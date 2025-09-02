package com.gyojincompany.oracle.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BoardDto {
	
	private int bnum; // 기본키
	private String btitle;
	private String bcontent;
	private String bwriter;
	private int bhit;
	private String bdate; // timestamp 타입으로 하면 fmt로 날짜 형식 변경 가능
	
	// BoardDto : MemberDto 1:1 관계
	private MemberDto memberDto;

}
