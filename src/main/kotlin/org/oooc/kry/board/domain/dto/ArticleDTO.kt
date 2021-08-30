package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Article
import org.oooc.kry.board.domain.entity.Board
import java.time.OffsetDateTime

data class ArticlePostRequestDTO(
    val title: String,
    val content: String,
    val created: OffsetDateTime
)

data class ArticlePostResponseDTO(
    val id: Long,
    val board: Board,
    val title: String,
    val content: String,
    val created: OffsetDateTime
)

data class ArticleGetResponseDTO(
    val id: Long,
    val board: Board,
    val title: String,
    val content: String,
    val created: OffsetDateTime,
    val modified: OffsetDateTime,
    val upvote: Long,
    val downvote: Long
)

data class ArticlePutRequestDTO(
    val board: Board = Board(),
    val title: String = "",
    val content: String = "",
    val modified: OffsetDateTime
)

data class ArticlePutResponseDTO(
    val id: Long,
    val board: Board,
    val title: String,
    val content: String,
    val created: OffsetDateTime,
    val modified: OffsetDateTime,
    val upvote: Long,
    val downvote: Long
)

data class ArticlesGetResponseDTO(
    val articles: List<Article>
)