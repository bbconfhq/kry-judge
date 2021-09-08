package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Comment
import javax.validation.constraints.NotNull

data class CommentVotePostRequestDTO(
    @field:NotNull val updown: Byte
)

data class CommentVotePostResponseDTO(
    val comment: Comment,
    val updown: Byte
)

data class CommentVoteDeleteRequestDTO(
    @field:NotNull val updown: Byte
)