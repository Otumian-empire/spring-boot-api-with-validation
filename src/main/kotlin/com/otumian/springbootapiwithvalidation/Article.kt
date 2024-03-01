package com.otumian.springbootapiwithvalidation

import java.time.LocalDateTime

data class ArticleDto(
    var id: Long?,
    var title: String,
    var content: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val slug: String = title.toSlug()
)
