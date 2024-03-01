package com.otumian.springbootapiwithvalidation

import org.springframework.stereotype.Service


interface Mapper<Dto, Entity> {
    fun fromEntityToDto(entity: Entity): Dto
    fun fromDtoToEntity(dto: Dto): Entity
}

@Service
class ArticleMapper : Mapper<ArticleDto, Article> {
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
