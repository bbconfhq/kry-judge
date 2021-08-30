package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.CommentVotePostRequestDTO
import org.oooc.kry.board.domain.dto.CommentVotePostResponseDTO
import org.oooc.kry.board.domain.dto.CommentVoteDeleteRequestDTO
import org.oooc.kry.board.web.service.CommentVoteService
import org.oooc.kry.global.dto.APIResponse
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class CommentVoteController(
    val commentVoteService: CommentVoteService
) {

    // CREATE COMMENT_VOTE
    @PostMapping("/{boardName}/article/{articleNo}/comment/{commentNo}/vote")
    fun createCommentVote(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @PathVariable commentNo: Long,
        @RequestBody commentVotePostRequestDTO: CommentVotePostRequestDTO
    ): APIResponse<CommentVotePostResponseDTO> {
        val commentVote = commentVoteService.createCommentVote(
            boardName = boardName,
            articleNo = articleNo,
            commentNo = commentNo,
            updown = commentVotePostRequestDTO.updown
        )
        val respDTO = CommentVotePostResponseDTO(
            comment = commentVote.comment,
            updown = commentVote.updown
        )
        return APIResponse(
            data = respDTO
        )
    }

    // DELETE COMMENT_VOTE
    @DeleteMapping("/{boardName}/article/{articleNo}/comment/{commentNo}/vote")
    fun deleteCommentVote(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @PathVariable commentNo: Long,
        @RequestBody commentVoteDeleteRequestDTO: CommentVoteDeleteRequestDTO
    ) {
        commentVoteService.deleteCommentVote(boardName, articleNo, commentNo, commentVoteDeleteRequestDTO.updown)
    }

}