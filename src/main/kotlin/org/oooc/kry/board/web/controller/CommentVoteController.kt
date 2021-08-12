package org.oooc.kry.board.web.controller

import org.oooc.kry.board.web.service.CommentVoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class CommentVoteController(val commentVoteService: CommentVoteService) {

    // CREATE COMMENT_VOTE
    @PostMapping("/{boardName}/article/{articleNo}/comment/{commentNo}/vote")
    fun createCommentVote(@PathVariable boardName: String,
                          @PathVariable articleNo: Long,
                          @PathVariable commentNo: Long,
                          @RequestParam updown: Byte) {

    }

    // DELETE COMMENT_VOTE
    @DeleteMapping("/{boardName}/article/{articleNo}/comment/{commentNo}/vote")
    fun deleteCommentVote(@PathVariable boardName: String,
                          @PathVariable articleNo: Long,
                          @PathVariable commentNo: Long,
                          @RequestParam updown: Byte) {

    }

}