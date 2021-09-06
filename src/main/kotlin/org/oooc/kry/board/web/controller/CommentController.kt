package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.*
import org.oooc.kry.board.web.service.CommentService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("board")
class CommentController(
    val commentService: CommentService
) {

    @PostMapping("/{boardName}/article/{articleNo}/comment")
    fun postComment(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @RequestBody @Valid commentPostRequestDTO: CommentPostRequestDTO
    ): APIResponse<CommentPostResponseDTO> {
        val comment = commentService.writeComment(
            boardName = boardName,
            articleNo = articleNo,
            content = commentPostRequestDTO.content,
            created = commentPostRequestDTO.created
        )
        val respDTO = CommentPostResponseDTO(
            id = comment.id,
            article = comment.article,
            content = comment.content,
            created = comment.created,
            modified = comment.modified,
            upvote = comment.upvote,
            downvote = comment.downvote
        )
        return APIResponse(
            data = respDTO
        )
    }

    @GetMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun getComment(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @PathVariable commentNo: Long
    ): APIResponse<CommentGetResponseDTO> {
        val comment = commentService.getComment(
            boardName = boardName,
            articleNo = articleNo,
            commentNo = commentNo
        )
        val respDTO =  CommentGetResponseDTO(
            id = comment.id,
            article = comment.article,
            content = comment.content,
            created = comment.created,
            modified = comment.modified,
            upvote = comment.upvote,
            downvote = comment.downvote
        )
        return APIResponse(
            data = respDTO
        )
    }

    @PutMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun putComment(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @PathVariable commentNo: Long,
        @RequestBody @Valid commentPutRequestDTO: CommentPutRequestDTO
    ): APIResponse<CommentPutResponseDTO> {
        val comment = commentService.modifyComment(
            boardName = boardName,
            articleNo = articleNo,
            commentNo = commentNo,
            newContent = commentPutRequestDTO.content,
            modified = commentPutRequestDTO.modified
        )
        val respDTO = CommentPutResponseDTO(
            id = comment.id,
            article = comment.article,
            content = comment.content,
            created = comment.created,
            modified = comment.modified,
            upvote = comment.upvote,
            downvote = comment.downvote
        )
        return APIResponse(
            data = respDTO
        )
    }

    @DeleteMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun deleteComment(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @PathVariable commentNo: Long
    ): APIResponse<CheckDTO> {
        commentService.deleteComment(boardName, articleNo, commentNo)
        return APIResponse(
            data = CheckDTO(
                success = true
            )
        )
    }

    @GetMapping("/{boardName}/article/{articleNo}/comment")
    fun getComments(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long
    ): APIResponse<CommentsGetResponseDTO> {
        val comments = commentService.getCommentsList(boardName, articleNo)
        val respDTO = CommentsGetResponseDTO(
            comments = comments
        )
        return APIResponse(
            data = respDTO
        )
    }

}