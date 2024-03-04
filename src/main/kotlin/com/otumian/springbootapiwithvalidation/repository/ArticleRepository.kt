package com.otumian.springbootapiwithvalidation.repository

import com.otumian.springbootapiwithvalidation.entity.Article
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : CrudRepository<Article, Long>