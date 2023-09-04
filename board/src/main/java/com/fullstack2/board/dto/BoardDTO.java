package com.fullstack2.board.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/*
 * 여기서는 게시판에서 보여지는 정보를 담는 DTO 정의.
 * 이미 정의한 쿼리에서 리스트에는 작성자, 게시글 수동을 가져오도록 했기에, 
 * 따로 여기서 member, reply 의 참조를 걸어서 데이터를 가져오진 않음
 * 하지만, 데이터를 보여주기는 해야하기에, 필드는 작성함.
 */

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	
	private Long bno;
	private String title;
	private String content;
	private String writerEmail;//작성자 이메일
	private String writerName;
	private LocalDateTime regDate;
	private LocalDateTime modDate;
	private int replyCount;
	
}



































