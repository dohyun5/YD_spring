package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;


public interface BookMapper {
	public List<BookVO> bookList();
	public int insertBook(BookVO vo);
	public String no();
}
