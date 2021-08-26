package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.domain.entity.Comment
import java.time.OffsetDateTime

class ArticleGetResponseDTO (
    var id: Long,
    var boardName: String,
    var title: String,
    var content: String,
    var created: OffsetDateTime,
    var modified: OffsetDateTime,
    var upvote: Long,
    var downvote: Long,
    var comments: List<Comment>
)