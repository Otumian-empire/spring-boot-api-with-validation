package com.otumian.springbootapiwithvalidation.mapper


interface ArticleMapper<Dto, Entity> {
    fun fromEntityToDto(entity: Entity): Dto
    fun fromDtoToEntity(dto: Dto): Entity
}
