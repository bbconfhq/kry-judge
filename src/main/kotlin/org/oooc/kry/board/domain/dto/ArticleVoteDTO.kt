package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Article
import javax.validation.constraints.NotNull

data class ArticleVotePostRequestDTO(
    @field:NotNull val updown: Byte
)

data class ArticleVotePostResponseDTO(
    val article: Article,
    val updown: Byte
)

data class ArticleVoteDeleteRequestDTO(
    @field:NotNull val updown: Byte
)
