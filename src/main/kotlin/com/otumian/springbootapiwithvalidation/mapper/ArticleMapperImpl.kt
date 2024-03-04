package com.otumian.springbootapiwithvalidation.mapper

import com.otumian.springbootapiwithvalidation.dto.ArticleDto
import com.otumian.springbootapiwithvalidation.entity.Article
import org.springframework.stereotype.Service


@Service
class ArticleMapperImpl : ArticleMapper<ArticleDto, Article> {
    override fun fromEntityToDto(entity: Article): ArticleDto {
        return ArticleDto(
            entity.id,
            entity.title,
            entity.content
        )
    }

    override fun fromDtoToEntity(dto: ArticleDto): Article {
        return Article(
            dto.id,
            dto.title,
            dto.content
        )
    }
}
