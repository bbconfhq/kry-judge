package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.ArticleVoteCreateRequestDTO
import org.oooc.kry.board.domain.dto.ArticleVoteCreateResponseDTO
import org.oooc.kry.board.domain.dto.ArticleVoteDeleteRequestDTO
import org.oooc.kry.board.domain.entity.ArticleVote
import org.oooc.kry.board.web.service.ArticleVoteService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*

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
        @RequestBody articleVoteCreateRequestDTO: ArticleVoteCreateRequestDTO
    ): APIResponse<ArticleVoteCreateResponseDTO> {
        val articleVote = articleVoteService.createArticleVote(
            boardName,
            articleNo,
            articleVoteCreateRequestDTO.updown
        )
        val respDTO = ArticleVoteCreateResponseDTO(
            articleVote.article,
            articleVote.updown
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
        @RequestBody articleVoteDeleteRequestDTO: ArticleVoteDeleteRequestDTO
    ): APIResponse<CheckDTO> {
        articleVoteService.deleteArticleVote(boardName, articleNo, articleVoteDeleteRequestDTO.updown)
        return APIResponse(
            data = CheckDTO(
                success = true
            )
        )
    }

}