package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.CommentCreateRequestDTO
import org.oooc.kry.board.web.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class CommentController(val commentService: CommentService) {

    // CREATE COMMENT
    @PostMapping("/{boardName}/article/{articleNo}/comment")
    fun postComment(@PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @RequestBody commentCreateRequestDTO: CommentCreateRequestDTO
    ) {
        commentService.createComment(boardName,
            articleNo,
            commentCreateRequestDTO.content,
            commentCreateRequestDTO.created
        )
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
