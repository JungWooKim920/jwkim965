package com.fullstack2.board.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fullstack2.board.entity.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {

	//JPQL(Java Persistence Query Language)
	//JPQL은 반드시 Repository 에만 정의 가능합니다.
	//DB로부터 Entity를 얻어내는 쿼리 어노테이션
	//Native : JPQL 을 대신해서 일반적인 SQL 을 정의해서 실행하는 속성
	//이 속성의 위 어노테이션에서 true 를 지정해야 함 사용가능 함.
	//연관관계가 있는 테이블 중 Board(중심테이블) 에 저장된 하나의 Row를 Select 합니다.
	//이 때 board의 writer 는 member 를 참조하고 있기 때문에 JPQL 에서는 Left Join 을 걸어서
	//연관된 정보를 얻어내야 합니다.
	//ex> Select.....From Entity명(반드시 첫자는 대문자//meme:엔티티클래스명과 똑같이) alias Left Join 조인필드명 alias 조건절 
	//아래는 board의 특정 글번호에 대한 Row 하나를 리턴하도록 정의함.
	//Join 이 Entity 에서는 기본적으로 리턴타입이 Object[] 입니다.
	//이유는 기본테이블의 Row와 조인 테이블의 Row를 하나로 합쳐서 리턴하기 때문..
	@Query("Select b, w "
			+ "From Board b "
			+ "LEFT JOIN b.writer w "
			+ "WHERE b.bno =:bno")
	Object getBoardWithWriter(@Param("bno") Long bno);
	
	//List 전체를 가져오는 JPQL 을 사용합니다.
	//Board 를 기준으로 Member의 writer 를 Reply의 댓글 내용도 가져옵니다.
	//이 때 사용해야 할 게 있는데, ON이라는 키워드입니다.
	//Board 를 기준으로 writer 는 Member 의 하나의 컬럼 값이지만,
	//Reply 된 글의 전체를 가져올 떄는, 반드시 board 와 reply 의 공통 컬럼에 on 키워드를 사용해서
	//이용해야 합니다.
	
	//게시글에 해당하는 댓글을 조인해서 가져옵니다.
	@Query("SELECT b, r "
			+ "FROM Board b "
			+ "LEFT JOIN Reply r "
			+ "ON r.board = b "
			+ "WHERE b.bno = :bno")
	List<Object[]> getBoardWithReply(@Param("bno") Long bno); 
	
	
	//특정 글 2번의 게시내용과(board 에서 get), 작성자(member),
	//2번 글에 해당되는 댓글을 모두 가져온다라고 하면, 문제가 하나 발생함
	//group by 를 써서 그룹으로 묶어서 쿼리를 정의 할게요.
	//주의!!!! 부트 버전 3.x 이후부터는 목록(list 페이지 등에서 활용할) 을 가져오는
	//쿼리를 작성할 때는 반드시 기준 테이블의 전체 목록을 리턴하도록 하는 count 쿼리를 작성해야 합니다.
	//그렇지 않으면 예외 발생합니다.
	@Query(value = "SELECT b, w, count(r) "
			+ "FROM Board b "
			+ "LEFT JOIN b.writer w "
			+ "LEFT JOIN Reply r ON r.board = b "
			+ "GROUP BY b", 
			countQuery = "SELECT count(b) FROM Board b")
	//list 페이지에서 사용될 전체 목록 쿼리이므로, Paging 처리를 위해 Page 객체로 리턴받도록 정의함
	Page<Object[]> getBoardWithReplyCount(Pageable pageable);
	
	
	//특정 게시글에 댓글이 몇 개 존재하는지 확인하는 쿼리 작성
	@Query("SELECT b, w, count(r) "
			+ "FROM Board b "
			+ "LEFT JOIN b.writer w "
			+ "LEFT OUTER JOIN Reply r "
			+ "ON r.board = b "
			+ "WHERE b.bno = :bno")
	Object getBoardByBno(@Param("bno") Long bno);
	
	
	
	//삭제 관련 JPQL 정의합니다.
	//일단 삭제에 관련해서는 몇 가지 생각할게 있는데
	//1. 자식글들이 있는 경우엔 어떻게 할 지를 결정해야 합니다.
	//2. 지금은 자식글까지 삭제를 한다라고 가정하고 진행할게요.
	//3. 그럼, 자식글이 먼저 지워지지 않은 상태에서 게시글(부모글)이 삭제되면
	//참조 무결성을 위배하게 됩니다. 따라서 삭제는 자식글부터 삭제하고
	//이후 부모글을 삭제합니다.
	//때문에 자식글의 CRUD는 ReplyRepository 에서 먼저 진행합니다. 
	
	
	
	
	
	
	
}


















