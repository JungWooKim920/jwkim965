package com.fullstack2.board.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
//아래 exclude 는 객체를 출력할 때 조인이 걸려있는 컬럼은 부모의 모든 ROW 같이 가져와 출력시킵니다.
//즉, 여러분이 writer(작성자)의 email만 보려해도, 부모테의블의 모든 컬럼까지 같이 나온다는 말입니다.
//매우 귀찮아지죠..따라서 아래처럼 exclude 를 설정하면 딱 board writer 의 값만 toString() 되어짐
@ToString(exclude = "writer")
public class Board extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bno;
	private String title;
	private String content;
	
	//작성자처리는 조금 있다가 할게요.
	//Member.email 이 참조가 되어야 합니다.
	//Boot 에서는 ManyToOne 이라는 @ 을 이용하면 자동으로 참조 부모 Entity 의
	//PK 를 참조시킵니다. 문법은 @ManyToOne 선언 후 부모Entity명 writer(보드의 컬럼명의 자동 추가됩니다.)
	//99% 는 하위 테이블에서 조인되는 부모컬럼에는 지연로딩(Lazy fetch 를 사용합니다).
	@ManyToOne(fetch = FetchType.LAZY)
	private Member writer;
	
	
	//title, content setter 만 추가할게요
	public void changeTitle(String title) {
		this.title = title;
	}
	
	public void changeContent(String content) {
		this.content = content;
	}
	
	
	
}



















