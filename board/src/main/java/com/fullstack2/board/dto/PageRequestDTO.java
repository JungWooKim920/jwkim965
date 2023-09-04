package com.fullstack2.board.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/*
 * 이 DTO 는 화면에서 사용자가 요청하는 페이지번호를 분석해서
 * 이 번호에 해당하는 글 목록갯수를 정보를 담는 DTO 입니다.
 * 
 * 이 DTO를 통해서 게시글의 뿌려질 결과 목록을 담은 다른 DTO 에서 사용하게됩니다.
 * 
 * 필드로는 사용자의 요청 페이지 번호, 글 목록 갯수를 선언하고
 * 기본 생성자를 통해서 1페이지, 10개의 목록으로 초기화 합니다.
 * 
 * 메서드로는 GuestBook 테이블에서 페이지번호에 해당하는 글 갯수를 조회 후
 * Pageable 로 리턴시키도록 정의합니다. 다른 DTO 에서는 이 Pageable 을 파람으로
 * 받아서 Page 를 생성, 뿌려지게 됩니다.
 * 
 * 페이지의 시작은 0부터 시작하니, 요청 페이지에서 항상 -1 을 해줘야 정상적인 페이지 Number가 됩니다.
 * 
 */
@Builder
@AllArgsConstructor
@Data
public class PageRequestDTO {

	private int page;
	private int size;
	
	//검색타입 및 키워드 등록
	private String type;
	private String keyword;
	
	
	public PageRequestDTO() {
		this.page = 1;
		this.size = 10;
	}
	
	public Pageable getPageable(Sort sort) {
		return PageRequest.of(page - 1, size, sort);
	}
	
	
	
	
	
}

















