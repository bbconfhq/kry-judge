package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Article
import org.oooc.kry.board.domain.entity.CommentVote
import java.time.OffsetDateTime

data class CommentGetResponseDTO (
    val id: Long,
    val article: Article,
    val content: String,
    val created: OffsetDateTime,
    val modified: OffsetDateTime,
    val upVote: Long,
    val downVote: Long,
    val commentVotes: List<CommentVote>
)