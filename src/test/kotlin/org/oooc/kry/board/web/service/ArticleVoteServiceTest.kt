package org.oooc.kry.board.web.service

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@SpringBootTest
internal class ArticleVoteServiceTest(
    @Autowired val articleVoteService: ArticleVoteService,
) {
    val boardService = articleVoteService.boardService
    val articleService = articleVoteService.articleService
    val articleVoteRepository = articleVoteService.articleVoteRepository

    @Test
    @Transactional
    @Commit
    fun createArticleVote() {
        boardService.createBoard("board1", 100)
        val article = articleService.writeArticle("board1", "title1", "content1", OffsetDateTime.now())
        articleVoteService.createArticleVote("board1", article.id, -1)
    }

}