package com.otumian.springbootapiwithvalidation.entity

import com.otumian.springbootapiwithvalidation.extension.toSlug
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime


@Entity
class Article(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long?,
    var title: String,
    var content: String,
    var createdAt: LocalDateTime = LocalDateTime.now(),
    var slug: String = title.toSlug()
)