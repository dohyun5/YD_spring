package com.yedam.app.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) {
		BoardVO findNo = boardService.getBoardInfo(boardVO);
		model.addAttribute("boardInfo", findNo);
		return "board/boardInfo";
	}
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm(Model model) {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO boardVO, RedirectAttributes rtt) {
		boardService.insertBoardInfo(boardVO);
		rtt.addFlashAttribute("bno", boardVO.getBno());
		return "redirect:boardList";
	}
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(Model model) {
		return "board/boardUpdate";
	}
	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	//@PostMapping("boardUpdate")
	
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(BoardVO vo) {
		return "redirect:boardList";
	}
	
}
