package org.oooc.kry.board.web.service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@SpringBootTest
internal class ArticleServiceTest(
    @Autowired
    val articleService: ArticleService,
    @Autowired
    val boardService: BoardService
) {
    val articleRepository = articleService.articleRepository
    val boardRepository = boardService.boardRepository

    @Test
    @Commit
    @Transactional
    fun MANUAL_TEST_createArticle() {
        boardService.createBoard("board1", 1)
        articleService.createArticle("board1", "title1", "hello1", OffsetDateTime.now())
        articleService.createArticle("board1", "title2", "hello2", OffsetDateTime.now())
    }

    @Test
    fun getArticleRepository() {
    }

    @Test
    fun getBoardService() {
    }
}