package com.mustache.bbs.domain.dto;

import com.mustache.bbs.domain.Article;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleDto {
	private String title;
	private String content;
	
	public Article toEntity() {
		return new Article(title, content);
	}
}
