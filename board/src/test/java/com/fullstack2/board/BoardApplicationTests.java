package com.fullstack2.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.fullstack2.board.dto.BoardDTO;
import com.fullstack2.board.entity.Board;
import com.fullstack2.board.entity.Reply;
import com.fullstack2.board.repository.BoardRepository;
import com.fullstack2.board.repository.ReplyRepository;
import com.fullstack2.board.service.BoardService;

@SpringBootTest
class BoardApplicationTests {

	
	
	
	//private MemberRepository memberRepository;
	private BoardRepository boardRepository;
	@Autowired
	private ReplyRepository replyRepository;
	@Autowired
	private BoardService boardService;
	
	//@Test//댓글목록들 get test
	public void getReplies() {
		List<Reply> result = replyRepository.
				getRepliesByBoardOrderByRno(Board.builder().bno(85L).build());
		
		result.forEach(reply -> System.out.println(reply));
	}
	
	
	
	//@Test//수정테스트합니다.
	public void update() {
		BoardDTO dto = BoardDTO.builder()
								.bno(2L)
								.title("수정된 제목입니다")
								.content("수정된 내용입니다")
								.build();
		boardService.modify(dto);
	}
	
	
	
	//@Test//삭제 기능 테스트합니다.
	public void remove() {
		Long bno = 99L;
		
		boardService.removeWithReplies(bno);
	}
	
	
	
	//@Test//리스트 페이지의 글목록 get 테스트
	public void getPageList() {
	/*	
		PageRequestDTO dto = new PageRequestDTO();
		
		PageResultDTO<BoardDTO, Object[]> result = boardService.getList(dto);
		
		for(BoardDTO bDto : result.getDtoList()) {
			System.out.println(bDto);
		}
		*/
	}
	
	

	
	
	@Test//신규글 입력 test
	public void doSome() {
		
		BoardDTO dto = BoardDTO.builder()
						.title("이건 신규글 테스트입니다")
						.content("신규글의 내용입니다..코로나 조심")
						.writerEmail("user11@fst2.com")
						.build();
		
		boardService.register(dto);
		
	}
	
	
	
	
	//JPQL 을 이용한 Board 에서 특정 글번호에 해당하는 Row 얻어내기
	//@Test
	public void testGetOneRowFromBoard() {
		/*
		Object res = boardRepository.getBoardWithWriter(100L);
		
		Object[] theRow = (Object[])res;
		
		System.out.println(Arrays.toString(theRow));
		
		
		System.err.println("++++++++++++++++++++++++++++++++++++++++++++++");
		
		List<Object[]> res2= boardRepository.getBoardWithReply(3L);
		
		for(Object[] obj : res2) {
			System.out.println(Arrays.toString(obj));
		}
	
		Pageable pageable = PageRequest.of(0, 10, Sort.by("bno").descending());
		
		Page<Object[]> resPage = boardRepository.getBoardWithReplyCount(pageable);
		
		resPage.get().forEach(row -> {
			Object[] arr = (Object[])row;
			System.out.println(Arrays.toString(arr));
		});
		
		
		System.err.println("++++++++++++++++++++++++++++++++++++++++++++++");
		
		
		Object barr = boardRepository.getBoardByBno(3L);
		Object[] rArr = (Object[])barr;
		System.out.println(Arrays.toString(rArr));
		
		*/
		
	}
	
	
	
	
	
	
	//@Test //조인이 걸린 테이블에서 일반적인 조회를 실행 시의 모습 테스트
	public void nonFetchJoin() {
		/*
		Optional<Board> res = boardRepository.findById(100L);
		
		Board b = res.get();
		
		System.out.println(b);
		System.out.println(b.getWriter());
		*/
	}
	
	
	//@Test
	void contextLoads() {
		/*
		IntStream.rangeClosed(1, 400)
		 .forEach(i -> {
			 //Board 테이블의 부모인 Member 의 이메일값을 넣기 위한 테스트 멤버 생성 및 이메일만 세팅
			 Board board = Board.builder()
					 				.bno((long) (Math.random() * 100 ) + 1)
					 				.build();
			 Reply reply = Reply.builder()
					 			.text("이건 " + i +" 댓글입니다.")
					 			.replyer("댓글러" + i)
					 			.board(board)
					 			.build();
			 replyRepository.save(reply);
		 });
		*/
		
		/* 여기는 Member 샘플데이터 Insert Code
		IntStream.rangeClosed(1, 100)
				 .forEach(i -> {
					 Member member = Member.builder()
							 				.email("user" + i + "@fst2.com")
							 				.password("1111")
							 				.name("회원" + i)
							 				.build();
					 memberRepository.save(member);
				 });
		*/
	}
	

}
