package com.yedam.java.book.service;

import java.util.List;

public interface BookService {

	public List<BookVO> bookList(BookVO vo);
	public int insertBook(BookVO vo);
	public String no();
}
