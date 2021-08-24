package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.ArticleVoteCreateRequestDTO
import org.oooc.kry.board.domain.dto.ArticleVoteDeleteRequestDTO
import org.oooc.kry.board.domain.entity.ArticleVote
import org.oooc.kry.board.web.service.ArticleVoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class ArticleVoteController(val articleVoteService: ArticleVoteService) {

    // CREATE ARTICLE_VOTE
    @PostMapping("/{boardName}/article/{articleNo}/vote")
    fun createArticleVote(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @RequestBody articleVoteCreateRequestDTO: ArticleVoteCreateRequestDTO
    ) {
        articleVoteService.createArticleVote(boardName, articleNo, articleVoteCreateRequestDTO.updown)
    }

    // DELETE ARTICLE_VOTE
    @DeleteMapping("/{boardName}/article/{articleNo}/vote")
    fun deleteArticleVote(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long,
        @RequestBody articleVoteDeleteRequestDTO: ArticleVoteDeleteRequestDTO
    ) {
        articleVoteService.deleteArticleVote(boardName, articleNo, articleVoteDeleteRequestDTO.updown)
    }

}