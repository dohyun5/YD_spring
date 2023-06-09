package com.yedam.app.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {

	@Autowired
	BoardService boardService;
	
	
	// 전체조회 : URI - boardList, RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		//model.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo, RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String getBoardInfo(BoardVO boardVO, Model model) { //글번호 작가 두개를 요청
		BoardVO findBoard = boardService.getBoardInfo(boardVO);
		model.addAttribute("board", findBoard);
		return "board/boardInfo";
	}
	// 등록 - 페이지 : URI - boardInsert, RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() {
		return "board/boardInsert";
	}
	
	// 등록 - 처리 : URI - boardInsert, RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsert(BoardVO boardVO, Model model) {
		boardService.insertBoardInfo(boardVO);
		return "redirect:boardList";
	}
	/*
	 * public String boardInsert(BoardVO boardVO, RedirectAttributes rtt) {
	 * 	boardService.insertBoardInfo(boardVO); 
	 * 	rtt.addFlashAttribute("bno", boardVO.getBno()); 
	 * 	return "redirect:boardList"; 
	 * }
	 */
	
	// 수정 - 페이지 : URI - boardUpdate, RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(Model model, BoardVO boardVO) {
		BoardVO findVO = boardService.getBoardInfo(boardVO);
		model.addAttribute("board",findVO);
		return "board/boardUpdate";
	}
	// 수정 - 처리 : URI - boardUpdate, RETURN - 성공여부만 반환
	@PostMapping("boardUpdate")
	@ResponseBody //페이지가 아닌 데이터를 반환하겠다는 의미.
	public Map<String, Object> boardUpdate(BoardVO boardVO){
		boolean result = false;
		int boardNo = boardService.updateBoardInfo(boardVO);
		if(boardNo > -1) {
			result = true;
		}
		Map<String, Object> map = new HashMap<>();
		map.put("result", result);
		map.put("board_no", boardNo);
		
		return map;
	}
	
	// 삭제 : URI - boardDelete, RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam(required=false,defaultValue ="0",name="bno") int boardNo) { 
					//RequestParam사용시 데이터를 넘겨주지 않으면 에러를 표시함.required 기본값이 true임.
					//RequestParam속성 3가지 (필수여부, 값이 넘어오지 않았을때 넣어주는 값(기본값:null),실제 변수의 이름과 넘어오는 키값의 이름이 다를때 사용.) 
		boardService.deleteBoardInfo(boardNo);
		return "redirect:boardList";
	}
	
}
