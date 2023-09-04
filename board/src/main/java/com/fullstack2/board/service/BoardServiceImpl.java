package com.fullstack2.board.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fullstack2.board.dto.BoardDTO;
import com.fullstack2.board.dto.PageRequestDTO;
import com.fullstack2.board.dto.PageResultDTO;
import com.fullstack2.board.entity.Board;
import com.fullstack2.board.entity.Member;
import com.fullstack2.board.repository.BoardRepository;
import com.fullstack2.board.repository.ReplyRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	
	private final BoardRepository boardRepository;
	private final ReplyRepository replyRepository;
	
	
	@Override
	public Long register(BoardDTO dto) {
		Board board = dtoToEntity(dto);
		boardRepository.save(board);
		return board.getBno();
	}

	@Override
	public PageResultDTO<BoardDTO, Object[]> getList(PageRequestDTO pageRequestDTO) {
		Function<Object[], BoardDTO> fn = 
				(en -> entityToDTO((Board)en[0], (Member)en[1], (Long)en[2]) );
		Page<Object[]> result = 
				boardRepository.getBoardWithReplyCount(
						pageRequestDTO.getPageable(Sort.by("bno").descending()));
		
		return new PageResultDTO<>(result, fn);
	}

	@Override
	public BoardDTO get(Long bno) {
		Object result = boardRepository.getBoardByBno(bno);
		
		Object[] arr = (Object[]) result;
		
		return entityToDTO((Board)arr[0] , (Member)arr[1], (Long)arr[2] );
	}

	//게시글 삭제 메서드 정의.
	@Transactional //자식 삭제 후 부모 삭제를 수행하도록 선언함. 안 하면 하나 삭제 후 끝나버림.
	@Override
	public void removeWithReplies(Long bno) {
		
		replyRepository.deleteByBno(bno);
		boardRepository.deleteById(bno);
		
		
	}
	
	@Transactional
	@Override
	public void modify(BoardDTO dto) {
		Board board = boardRepository.getReferenceById(dto.getBno());
		
		board.changeContent(dto.getContent());
		board.changeTitle(dto.getTitle());
		
		boardRepository.save(board);
		
	}
	
	
}






















