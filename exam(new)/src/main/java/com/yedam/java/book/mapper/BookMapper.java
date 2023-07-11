package com.yedam.java.book.mapper;

import java.util.List;

import com.yedam.java.book.service.BookVO;
import com.yedam.java.book.service.RentVO;

public interface BookMapper {
	
	//전체조회
	public List<BookVO> selectAllBook();
	
	//단건조회(도서번호 예측을 위해서 필요 - 꼭 보여주진 않더라도 하나의 결과를 가져와야할때 )
	public int getBookNo();
	
	//등록
	public int insertBookInfo(BookVO bookVO);
	
	//대여현황조회
	public List<RentVO> selectBookRent();
}
