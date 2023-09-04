package com.fullstack2.board.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fullstack2.board.entity.Board;
import com.fullstack2.board.entity.Reply;


public interface ReplyRepository extends JpaRepository<Reply, Long> {

	//이건 SELECT 이 아니야!!! UP, DEL 둘 중의 하나를 수행할거야 라는 어노테이션을 반드시 선언해야 함
	@Modifying
	@Query("DELETE FROM Reply r WHERE r.board.bno = :bno")
	public void deleteByBno(@Param("bno") Long bno);
	
	//List 페이지에 댓글들 가져오는 목록처리 하기
	//쿼리 메서드를 이용한 board 에 참여한 댓글들 get
	List<Reply> getRepliesByBoardOrderByRno(Board board);
	
	
}
