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
	
	public void setBookPrice(Integer bookPrice) {
		if(bookPrice == null ) {
			this.bookPrice = 0;
		}else {
			this.bookPrice = bookPrice;
		}
		
	}
	
//	public void setBookPrice(String bookPrice) {
//		if(bookPrice == null || !bookPrice.equals("")) {
//			this.bookPrice = 0;
//		}else {
//			this.bookPrice = Integer.parseInt(bookPrice);
//		}
//	} 왜 0이 나옴? 이상함.
	
	
	
	
}
