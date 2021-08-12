package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Comment

data class CommentsGetResponseDTO (
    var comments: List<Comment>
)