package com.otumian.springbootapiwithvalidation.service

import com.otumian.springbootapiwithvalidation.dto.ArticleDto


interface ArticleService {
    fun createArticle(article: ArticleDto): ArticleDto
    fun getArticles(): List<ArticleDto>
    fun getArticleById(id: Long): ArticleDto
    fun updateArticle(id: Long, article: ArticleDto): ArticleDto
    fun deleteArticleById(id: Long)
}