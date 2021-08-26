package org.oooc.kry.board.web.controller

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.oooc.kry.board.web.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@SpringBootTest
@Transactional
internal class ArticleControllerTest(
    @Autowired val articleController: ArticleController,
    @Autowired val boardController: BoardController
) {
    val articleService = articleController.articleService
    val boardService = articleService.boardService


    @Test
    fun postArticle() {
    }

    @Test
    fun getArticle() {
    }

    @Test
    fun putArticle() {
    }

    @Test
    fun deleteArticle() {
    }

    @Test
    fun getArticles() {
    }

    @Test
    fun getArticleService() {
        val board = boardService.createBoard("board1", 100)
        val article1 = articleService.createArticle("board1", "title1", "content1", OffsetDateTime.now())
        val article2 = articleService.createArticle("board1", "title2", "content2", OffsetDateTime.now())
        println(articleController.getArticles("board1"))
    }
}