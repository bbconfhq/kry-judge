package org.oooc.kry.board.web.controller

import org.oooc.kry.board.web.service.ArticleVoteService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class ArticleVoteController(val articleVoteService: ArticleVoteService) {

    // CREATE ARTICLE_VOTE
    @PostMapping("/{boardName}/article/{articleNo}/vote")
    fun createArticleVote(@PathVariable boardName: String, @PathVariable articleNo: Long, @RequestParam updown: Byte) {

    }

    // DELETE ARTICLE_VOTE
    @DeleteMapping("/{boardName}/article/{articleNo}/vote")
    fun deleteArticleVote(@PathVariable boardName: String, @PathVariable articleNo: Long, @RequestParam updown: Byte) {

    }

}