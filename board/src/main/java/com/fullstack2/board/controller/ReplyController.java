package com.fullstack2.board.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fullstack2.board.dto.ReplyDTO;
import com.fullstack2.board.service.ReplyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/replies/")
@RequiredArgsConstructor
public class ReplyController {

	private final ReplyService replyService;
	
	//요청을 mapping 시 /path, /path/글번호같은 값이 올 경우에
	//이 값을 자동으로 mapping 시키는 code 가 있는데, 그게 {} 안에
	//매핑되어질 요청 파라미터 이름을 넣어주면, 그 타입에 맞는 값이 오면
	//자동으로 매핑됩니다.
	//꼭 기억2...Rest 서버는 반드시 value 를 통해 요청 매핑을 하고, 리턴해주는
	//리턴 데이터 타입을 명시해야 합니다. 반드시!!!!!!
	//그래야 클라이언트 브라우저가 해당 데이터를 받을 준비를 할 수 있기 때문입니다.
	@GetMapping(value = "/board/{bno}", produces = MediaType.APPLICATION_JSON_VALUE)
	//Jason 으로 응답을 하는 boot 는 반드시 jason 데이터를 담고 있는 응답객체를 리턴해야 합니다.
	//그 이름이 ResponseEntity 라는 객체입니다.
	//이 객체에 파라미터를 바인딩 시키는 DTO 를 제네릭으로 매핑시키면 알아서 주입합니다.
	public ResponseEntity<List<ReplyDTO>> getListByBoard(@PathVariable("bno") Long bno) {
	
		
		return new ResponseEntity<>(replyService.getList(bno), HttpStatus.OK);
	}
	
	//댓글등록 컨트롤러 처리
	//Rest API는 오쳥을 처리할 때 ajax 데이터가 전송되면, 파라미터를
	//받는 어노테이션이 따로 존재합니다.
	//@RequestBody 객체이고, 이걸 DTO에 주입시키도록 선언만 합니다.
	@PostMapping("")
	public ResponseEntity<Long> register(@RequestBody ReplyDTO replyDTO) {
		
		Long rno = replyService.register(replyDTO);
		
		return new ResponseEntity<>(rno, HttpStatus.OK);
	}
	
	//댓글 삭제 컨트롤러 구현.
	//요청이 path/댓글번호 오기 때문에 반드시 path 매핑을 해줘야 합니다.
	//값이 숫자형태인 rno 이니깐 받는 타입도 반드시 정수로 매핑해줘야 합니다.
	//또한 기존 댓글의 삭제 요청을 ajax로 보내기 때문에 요청메서드 매핑도 반드시
	//Delete 로 받아야 합니다.(ajax 등 비동기 통신은 클라이언트가 요청 시마다
	//요청 조건(조회(get), 등록(Post), 삭제(Delete), 수정(Put) ) 등으로
	//보내기 때문에 반드시 해당 메서드에 맞는 요청 및 응답처리를 해줘야 합니다.
	@DeleteMapping("/{rno}")//replies/rno 로 요청이 오면 rno 로 받겠다는 의미
	public ResponseEntity<String> remove(@PathVariable("rno") Long rno) {
		//이 메서드에서는 삭제만을 처리하기 때문에 삭제된 엔티티에 대한 정보를 보낼 수 없음
		//때문에 제대로 삭제가 되었다는 메세지만 보내도록 처리함
		
		replyService.remove(rno);
		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
		
	}
	
	@PutMapping("/{rno}")//replies/rno 로 요청이 오면 rno 로 받겠다는 의미
	public ResponseEntity<String> modify(@RequestBody ReplyDTO dto) {
		//이 메서드에서는 삭제만을 처리하기 때문에 삭제된 엔티티에 대한 정보를 보낼 수 없음
		//때문에 제대로 삭제가 되었다는 메세지만 보내도록 처리함
		
		replyService.modify(dto);
		
		return new ResponseEntity<String>("Success", HttpStatus.OK);
		
	}
	
	
	
	
}




























