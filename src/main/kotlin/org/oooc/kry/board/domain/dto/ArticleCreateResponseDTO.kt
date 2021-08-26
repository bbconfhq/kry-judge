package org.oooc.kry.board.domain.dto

import java.time.OffsetDateTime

data class ArticleCreateResponseDTO (
    val id: Long,
    val boardName: String,
    val title: String,
    val content: String,
    val created: OffsetDateTime,
    val modified: OffsetDateTime,
    val upvote: Long,
    val downvote: Long
)