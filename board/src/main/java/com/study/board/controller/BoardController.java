package com.study.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.study.board.entity.Board;
import com.study.board.service.BoardService;

import aj.org.objectweb.asm.Attribute;

import  org.springframework.ui.Model;

@Controller
public class BoardController {
	
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board/write")
	public String boardWriteForm() {
		
		return "boardwrite";
	}
	
	@PostMapping("/board/writepro")
	public String boardWritePro(Board board) {
		
		boardService.write(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/list")
	public String boardList(Model model) {
		
		model.addAttribute("list", boardService.boardList());
		
		return "boardList";
	}
	
	@GetMapping("/board/view") //localhost:8080/board/view?id=1
	public String boardView(Model model, Integer id) {
		
		model.addAttribute("board", boardService.boardview(id));
		return  "boardView";
	}
	
	@GetMapping("/board/delete")
	public String boardDelete(Integer id) {
		
		boardService.boardDelete(id);
		return "redirect:/board/list";
	}
	
	@GetMapping("/board/modify/{id}")
	public String boardModify(@PathVariable("id") Integer id , Model model) {
		
		model.addAttribute("board", boardService.boardview(id));
		return "boardmodify";
	}
	
	@PostMapping("/board/update/{id}")
	public String boardUpdate(@PathVariable("id") Integer id, Board board) {
		
		Board boardTemp = boardService.boardview(id);
		boardTemp.setTitle(board.getTitle());
		boardTemp.setContent(board.getContent());
		
		boardService.write(boardTemp);
		
		return "redirect:/board/list";
	}
}
