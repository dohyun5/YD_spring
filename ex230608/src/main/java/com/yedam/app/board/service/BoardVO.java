package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	
	private int bno;
	private String title;
	private String contents;
	private String writer;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate;//util.date = yyyy/mm/dd  input yyyy-mm-dd(하이픈)
	@DateTimeFormat(pattern="yyyy-MM-dd") //들어가는 DATE패턴. 
	private Date updatedate;
	private String image;
	
	
}
