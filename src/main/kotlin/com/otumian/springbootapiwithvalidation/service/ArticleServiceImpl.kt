package com.otumian.springbootapiwithvalidation.service

import com.otumian.springbootapiwithvalidation.dto.ArticleDto
import com.otumian.springbootapiwithvalidation.entity.Article
import com.otumian.springbootapiwithvalidation.handler.CustomException
import com.otumian.springbootapiwithvalidation.mapper.ArticleMapper
import com.otumian.springbootapiwithvalidation.repository.ArticleRepository
import com.otumian.springbootapiwithvalidation.validation.IArticleValidator
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service


@Service
class ArticleServiceImpl(
    private val repository: ArticleRepository,
    private val mapper: ArticleMapper<ArticleDto, Article>,
    private val validation: IArticleValidator // comment this out
): ArticleService {
    override fun createArticle(article: ArticleDto): ArticleDto {
        article.id = null

        // we are programmatically doing validation on the incoming article
        // this will throw a ValidationException
        // validation.article.validate(article)
        // commented out because we are now using the bean validation

        val entity = mapper.fromDtoToEntity(article)
        repository.save(entity)

        return mapper.fromEntityToDto(entity)
    }

    override fun getArticles(): List<ArticleDto> {
        return repository.findAll().map { mapper.fromEntityToDto(it) }
    }

    override fun getArticleById(id: Long): ArticleDto {
//        validation.id.validate(id)

        val entity = repository.findByIdOrNull(id) ?: throw CustomException("Article with id, $id, not found")
        return mapper.fromEntityToDto(entity)
    }

    override fun updateArticle(id: Long, article: ArticleDto): ArticleDto {
//        validation.id.validate(id)
//        validation.article.validate(article)

        val entity = repository.findByIdOrNull(id) ?: throw CustomException("Article with id, $id, not found")
        entity.title = article.title!!
        entity.content = article.content!!
        repository.save(entity)

        return mapper.fromEntityToDto(entity)
    }

    override fun deleteArticleById(id: Long) {
//        validation.id.validate(id)

        val entity = repository.findByIdOrNull(id) ?: throw CustomException("Article with id, $id, not found")
        repository.delete(entity)
    }
}