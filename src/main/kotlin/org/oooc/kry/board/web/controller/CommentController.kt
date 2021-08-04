package org.oooc.kry.board.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class CommentController {

    // CREATE COMMENT
    @PostMapping("/{boardName}/article/{articleNo}/comment")
    fun postComment() {

    }

    // GET COMMENT
    @GetMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun getComment() {

    }

    // DELETE COMMENT
    @DeleteMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun deleteComment() {

    }

    // GET LIST OF COMMENTS
    @GetMapping("/{boardName}/article/{articleNo}/comment")
    fun getComments() {

    }

}
