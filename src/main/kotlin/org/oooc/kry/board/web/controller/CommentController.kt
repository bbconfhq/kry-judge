package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.CommentCreateRequestDTO
import org.oooc.kry.board.domain.dto.CommentGetResponseDTO
import org.oooc.kry.board.domain.dto.CommentsGetResponseDTO
import org.oooc.kry.board.web.service.CommentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class CommentController(
    val commentService: CommentService
) {

    // CREATE COMMENT
    @PostMapping("/{boardName}/article/{articleNo}/comment")
    fun postComment(
        @PathVariable boardName: String,
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
    fun getComment(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @PathVariable commentNo: Long
    ): CommentGetResponseDTO {
        val comment = commentService.getComment(boardName, articleNo, commentNo)
        return CommentGetResponseDTO(
            id = comment.id,
            article = comment.article,
            content = comment.content,
            created = comment.created,
            modified = comment.modified,
            upVote = comment.upVote,
            downVote = comment.downVote,
            commentVotes = comment.commentVotes
        )
    }

    // DELETE COMMENT
    @DeleteMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun deleteComment(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @PathVariable commentNo: Long
    ) {
        commentService.deleteComment(boardName, articleNo, commentNo)
    }

    // GET LIST OF COMMENTS
    @GetMapping("/{boardName}/article/{articleNo}/comment")
    fun getComments(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long
    ): CommentsGetResponseDTO {
        val commentsList = commentService.getCommentsList(boardName, articleNo)
        return CommentsGetResponseDTO(commentsList)
    }

}
