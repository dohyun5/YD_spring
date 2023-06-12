package com.yedam.java.book.service;

import java.util.Date;

import lombok.Data;

@Data
public class BookVO {
	private int bookNo;
	private String bookName;
	private String bookCoverimg;
	private Date bookDate;
	//기본 : yyyy/MM/dd
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
}
