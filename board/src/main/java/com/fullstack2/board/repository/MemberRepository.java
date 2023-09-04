package com.fullstack2.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fullstack2.board.entity.Member;

public interface MemberRepository extends JpaRepository<Member, String> {

	
}
