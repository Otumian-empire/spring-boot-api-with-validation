package com.otumian.springbootapiwithvalidation

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository

interface ArticleRepository : JpaRepository<Article, Long>