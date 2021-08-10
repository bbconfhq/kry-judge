package org.oooc.kry.board.web.service

import org.assertj.core.api.Assertions
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
        boardService.createBoard("board2", 2)
        val article1 = articleService.createArticle("board2", "title1", "hello1", OffsetDateTime.now())
        val findArticle = articleService.getArticle(article1.board.name, article1.id)
        Assertions.assertThat(article1.title).isEqualTo(findArticle.get().title)
        Assertions.assertThat(article1.content).isEqualTo(findArticle.get().content)
    }

    @Test
    fun getBoardService() {
    }
}