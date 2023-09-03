package com.mustache.bbs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mustache.bbs.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Long>{

}
