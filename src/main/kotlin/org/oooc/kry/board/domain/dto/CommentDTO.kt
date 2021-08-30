package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Article
import org.oooc.kry.board.domain.entity.Comment
import java.time.OffsetDateTime

data class CommentPostRequestDTO(
    val content: String,
    val created: OffsetDateTime
)

data class CommentPostResponseDTO(
    val id: Long,
    val article: Article,
    val content: String,
    val created: OffsetDateTime,
    val modified: OffsetDateTime,
    val upvote: Long,
    val downvote: Long
)

data class CommentGetResponseDTO(
    val id: Long,
    val article: Article,
    val content: String,
    val created: OffsetDateTime,
    val modified: OffsetDateTime,
    val upvote: Long,
    val downvote: Long
)

data class CommentPutRequestDTO(
    val content: String,
    val modified: OffsetDateTime
)

data class CommentPutResponseDTO(
    val id: Long,
    val article: Article,
    val content: String,
    val created: OffsetDateTime,
    val modified: OffsetDateTime,
    val upvote: Long,
    val downvote: Long
)

data class CommentsGetResponseDTO(
    val comments: List<Comment>
)