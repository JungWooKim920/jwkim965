package com.fullstack2.board.service;

import java.util.List;

import com.fullstack2.board.dto.ReplyDTO;
import com.fullstack2.board.entity.Board;
import com.fullstack2.board.entity.Reply;

public interface ReplyService {

	//댓글에 관련 필요한 메서드 일단 선언...
	
	//댓글 등록
	Long register(ReplyDTO dto);
	
	//특정 게시글에 할당된 댓글목록을 가져오는 메서드 선언
	List<ReplyDTO> getList(Long bno);
	
	//댓글 수정하기 기능
	void modify(ReplyDTO dto);
	
	//댓글 샂게
	void remove(Long rno);
	
	
	//DTO --> Entity
	default Reply dtoToEntity(ReplyDTO dto) {
		//글번호가 필요하니 Board Entity 참조
		Board board = Board.builder().bno(dto.getBno()).build();
		
		Reply reply = Reply.builder()
						.rno(dto.getRno())
						.text(dto.getText())
						.replyer(dto.getReplyer())
						.board(board)
						.build();
		return reply;
		
	}
	
	
	//Entity --> DTO
	default ReplyDTO entityToDTO(Reply reply) {
		
		ReplyDTO dto = ReplyDTO.builder()
						.rno(reply.getRno())
						.text(reply.getText())
						.replyer(reply.getReplyer())
						.regDate(reply.getRegdate())
						.modDate(reply.getModDate())
						.build();
		return dto;
	}
	
	
	
	
	
	
	
}
