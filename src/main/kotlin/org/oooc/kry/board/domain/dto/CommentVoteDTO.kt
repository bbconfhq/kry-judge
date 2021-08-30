package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Comment

data class CommentVotePostRequestDTO(
    val updown: Byte
)

data class CommentVotePostResponseDTO(
    val comment: Comment,
    val updown: Byte
)

data class CommentVoteDeleteRequestDTO(
    val updown: Byte
)