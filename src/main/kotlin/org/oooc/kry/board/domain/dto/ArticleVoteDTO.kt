package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Article

data class ArticleVotePostRequestDTO(
    val updown: Byte
)


data class ArticleVotePostResponseDTO(
    val article: Article,
    val updown: Byte
)

data class ArticleVoteDeleteRequestDTO(
    val updown: Byte
)
