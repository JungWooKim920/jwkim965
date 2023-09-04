package com.fullstack2.board.service;

import com.fullstack2.board.dto.BoardDTO;
import com.fullstack2.board.dto.PageRequestDTO;
import com.fullstack2.board.dto.PageResultDTO;
import com.fullstack2.board.entity.Board;
import com.fullstack2.board.entity.Member;

public interface BoardService {

	
	//신규글 등록 메서드
	Long register(BoardDTO dto);
	
	//list 페이지에서 페이지에 해당하는 글목록 조회 리스트 get 메서드 저으이
	PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO);
	
	//특정 게시물의 정보를 리턴하는 메서드 선언(상세, 수정, 삭제 등에 쓰임)
	BoardDTO get(Long bno);
	
	
	//특정 게시물 삭제 메서드 정의
	void removeWithReplies(Long bno);	
	
	
	//게시물 수정 메서드 선언
	void modify(BoardDTO dto);
	
	
	
	//SELECT 시 리턴이 Object[] 입니다. 조인테이블을 사용할 때는 이렇게 리턴됨.
	//때문에 위 Object[] Entity 를 DTO 로 변환해줘야 합니다.
	default BoardDTO entityToDTO(Board board, Member member, Long replyCount) {
		
		BoardDTO dto = BoardDTO.builder()
								.bno(board.getBno())
								.title(board.getTitle())
								.content(board.getContent())
								.regDate(board.getRegdate())
								.modDate(board.getModDate())
								.writerEmail(member.getEmail())
								.writerName(member.getName())
								.replyCount(replyCount.intValue())
								.build();
		return dto;
	}
	
	
	
	
	
	//dtoToEntity 변환 메서드 정의합니다.
	default Board dtoToEntity(BoardDTO dto) {
		
		Member member = Member.builder().email(dto.getWriterEmail()).name(dto.getWriterName()).build();
		Board board = Board.builder()
						.bno(dto.getBno())
						.title(dto.getTitle())
						.content(dto.getContent())
						.writer(member)
						.build();
		return board;
		
	}
	
	
}
