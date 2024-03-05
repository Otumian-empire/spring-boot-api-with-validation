package com.otumian.springbootapiwithvalidation.dto

import com.otumian.springbootapiwithvalidation.bean.validation.HasAdequateWords
import com.otumian.springbootapiwithvalidation.extension.toSlug
import jakarta.validation.constraints.NotBlank
import java.time.LocalDateTime


data class ArticleDto(
    var id: Long?,

//    @field:NotNull(message = "title must not be null")
//    @field:NotBlank(message = "title must not be blank")
//    @field:NotEmpty(message = "title must not be empty")
//    @field:HasAdequateWords(min = 3, max = 10, message = "title must be between 3 to 10 words")
    @field:HasAdequateWords(message = "title must be at most 10 words")
//    @field:Size(min = 3, max = 10, message = "title should have between 3 to a max of 10 words")
    var title: String?,

//    @field:NotNull(message = "content must not be null")
//    @field:NotBlank(message = "content must not be blank")
//    @field:NotEmpty(message = "content must not be empty")
    @field:HasAdequateWords(min = 10, max = 25, message = "content must be between 10 to 25 words")
//    @field:HasMaximumWord(message = "content must be at most 10 words")
//    @field:Size(min = 10, max = 20, message = "content should have between 10 to a max of 20 words")
    var content: String?,

    val createdAt: LocalDateTime = LocalDateTime.now(), val slug: String? = title?.toSlug()
)
