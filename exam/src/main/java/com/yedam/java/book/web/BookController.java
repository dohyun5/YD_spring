package com.yedam.java.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yedam.java.book.service.BookService;
import com.yedam.java.book.service.BookVO;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	@RequestMapping("/bookList")
	public String bookList(Model model, BookVO vo) {
		model.addAttribute("bookList",bookService.bookList(vo));
		return "book/bookList";
	}
	
	@GetMapping("bookInsert")
	public String insertBookForm(Model model) {
		model.addAttribute("bno",bookService.no());
		return "book/bookInsert";
	}
	@PostMapping("bookInsert")
	public String bookInsert(BookVO vo,Model model) {
		bookService.insertBook(vo);
		return "redirect:bookList";
	}
	
	
}
