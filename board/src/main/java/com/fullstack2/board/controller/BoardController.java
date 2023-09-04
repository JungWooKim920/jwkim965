package com.fullstack2.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fullstack2.board.dto.BoardDTO;
import com.fullstack2.board.dto.PageRequestDTO;
import com.fullstack2.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/board/")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("/list")
	public void list(PageRequestDTO pageRequestDTO, Model model) {
		//Model 에게 List 에서 뿌려질 항목 DTO 를 전달해 줍니다.
		
		model.addAttribute("result", boardService.getList(pageRequestDTO));
	}
	
	//신규글 등록폼 요청처리하기
	@GetMapping("/register")
	public void register() {
		
	}
	
	//신규글 등록처리하기..
	//글 등록은 service를 통해서 하고, 새로 받은 board의 글번호는 redirect 로 list
	//페이지로 넘길게요.
	@PostMapping("/register")
	public String register(BoardDTO dto, RedirectAttributes attributes) {
		
		long newBno = boardService.register(dto);
		
		attributes.addFlashAttribute("newBno", newBno);
		
		return "redirect:/board/list";
	}
	
	//글상세를 처리하는 read 정의함.
	@GetMapping({"/read","/modify"})
	public void read(@ModelAttribute("requestDTO")
	PageRequestDTO pageRequestDTO, Long bno, Model model) {
		BoardDTO boardDTO = boardService.get(bno);
		
		model.addAttribute("dto", boardDTO);
	}
	
	
	
	//게시물 수정 삭제 처리 모두 정의하기...
	@PostMapping("/modify")
	public String modify(BoardDTO dto, @ModelAttribute("requestDTO") 
	PageRequestDTO requestDTO, RedirectAttributes redirect) {
		
		//글 수정시킨 후 read 로 redirect 시킵니다.
		boardService.modify(dto);
		
		//read 페이지로 보낼 때, 몇 페이지의 몇 번 글인지를 알아야 해서 이 폼에 보면 hidden으로
		//필수 정보를 설정했음... 따라서 그 값을 파라미터로 넘김
		
		redirect.addAttribute("page", requestDTO.getPage());
		redirect.addAttribute("bno", dto.getBno());
		
		return "redirect:/board/read";
	}
	
	
	//삭제 처리하기... 삭제는 댓글부터 시작해서 부모글을 지웁니다.
	//읽을 내용이 없으니, list로 다시 redirect 시킵니다.
	@PostMapping("/remove")
	public String remove(long bno, RedirectAttributes redirect) {
		
		boardService.removeWithReplies(bno);
		
		redirect.addAttribute("newBno", bno);
		
		return "redirect:/board/list";
		
	}
	
	
	@GetMapping("/restT")
	public void restT() {
		
	}
	
	
	
	
}




















