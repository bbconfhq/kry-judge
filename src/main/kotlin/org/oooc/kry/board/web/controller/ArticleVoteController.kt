package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.ArticleVotePostRequestDTO
import org.oooc.kry.board.domain.dto.ArticleVoteDeleteRequestDTO
import org.oooc.kry.board.domain.dto.ArticleVotePostResponseDTO
import org.oooc.kry.board.web.service.ArticleVoteService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("board")
class ArticleVoteController(
    val articleVoteService: ArticleVoteService
) {

    // CREATE ARTICLE_VOTE
    @PostMapping("/{boardName}/article/{articleNo}/vote")
    fun createArticleVote(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @RequestBody @Valid articleVotePostRequestDTO: ArticleVotePostRequestDTO
    ): APIResponse<ArticleVotePostResponseDTO> {
        val articleVote = articleVoteService.createArticleVote(
            boardName = boardName,
            articleNo = articleNo,
            updown = articleVotePostRequestDTO.updown
        )
        val respDTO = ArticleVotePostResponseDTO(
            article = articleVote.article,
            updown = articleVote.updown
        )
        return APIResponse(
            data = respDTO
        )
    }

    // DELETE ARTICLE_VOTE
    @DeleteMapping("/{boardName}/article/{articleNo}/vote")
    fun deleteArticleVote(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @RequestBody @Valid articleVoteDeleteRequestDTO: ArticleVoteDeleteRequestDTO
    ): APIResponse<CheckDTO> {
        articleVoteService.deleteArticleVote(
            boardName = boardName,
            articleNo = articleNo,
            updown = articleVoteDeleteRequestDTO.updown
        )
        return APIResponse(
            data = CheckDTO(
                success = true
            )
        )
    }

}