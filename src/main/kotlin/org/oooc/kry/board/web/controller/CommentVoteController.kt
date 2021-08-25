package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.CommentVoteCreateRequestDTO
import org.oooc.kry.board.domain.dto.CommentVoteDeleteRequestDTO
import org.oooc.kry.board.web.service.CommentVoteService
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
        @RequestBody commentVoteCreateRequestDTO: CommentVoteCreateRequestDTO
    ) {
        commentVoteService.createCommentVote(boardName, articleNo, commentNo, commentVoteCreateRequestDTO.updown)
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