package com.mustache.bbs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mustache.bbs.domain.Article;
import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.repository.ArticleRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/articles")
@Slf4j
public class ArticleController {
	
	private final ArticleRepository articleRepository;
	
	public ArticleController(ArticleRepository articleRepository) {
		this.articleRepository =articleRepository;
	}

	@GetMapping("/new")
	public String createArticlePage() {
		
		return "new";
	}
	
	@PostMapping("")
	public String createArticle(ArticleDto articleDto) {
		Article savedArticle = articleRepository.save(articleDto.toEntity());
		return String.format("id:%d",savedArticle.getId());
	}
}
