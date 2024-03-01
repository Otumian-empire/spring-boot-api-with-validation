package com.otumian.springbootapiwithvalidation

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


interface ArticleService {
    fun createArticle(article: ArticleDto): ArticleDto
    fun getArticles(): List<ArticleDto>
    fun getArticleById(id: Long): ArticleDto
    fun updateArticle(id: Long, article: ArticleDto): ArticleDto
    fun deleteArticleById(id: Long)
}

@Service
class ArticleServiceImpl(
    private val repository: ArticleRepository, private val mapper: ArticleMapper
): ArticleService {
    override fun createArticle(article: ArticleDto): ArticleDto {
        article.id = null

        val entity = mapper.fromDtoToEntity(article)
        repository.save(entity)

        return mapper.fromEntityToDto(entity)
    }

    override fun getArticles(): List<ArticleDto> {
        return repository.findAll().map { mapper.fromEntityToDto(it) }
    }

    override fun getArticleById(id: Long): ArticleDto {
        val entity = repository.findByIdOrNull(id) ?: throw Exception("Not found")
        return mapper.fromEntityToDto(entity)
    }

    override fun updateArticle(id: Long, article: ArticleDto): ArticleDto {
        val entity = repository.findByIdOrNull(id) ?: throw Exception("Not found")
        entity.title = article.title
        entity.content = article.content
        repository.save(entity)

        return mapper.fromEntityToDto(entity)
    }

    override fun deleteArticleById(id: Long) {
        val entity = repository.findByIdOrNull(id) ?: throw Exception("Not found")
        repository.delete(entity)
    }
}