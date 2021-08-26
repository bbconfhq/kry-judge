package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Article

data class ArticleVoteCreateResponseDTO (
    val article: Article,
    val updown: Byte
)