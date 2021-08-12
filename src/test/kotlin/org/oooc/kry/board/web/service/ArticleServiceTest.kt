package org.oooc.kry.board.web.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@SpringBootTest
internal class ArticleServiceTest(
    @Autowired
    val articleService: ArticleService,
) {
    val boardService = articleService.boardService
    val articleRepository = articleService.articleRepository
    val boardRepository = boardService.boardRepository

    @Test
    @Transactional
    fun write_article_test() {
        boardService.createBoard("board1", 1)
        articleService.createArticle("board1", "title1", "content1", OffsetDateTime.now())
        articleService.createArticle("board1", "title2", "content2", OffsetDateTime.now())
        articleService.createArticle("board1", "title3", "content3", OffsetDateTime.now())

        Assertions.assertThat(boardService.getBoard("board1").articles.size).isEqualTo(3)
    }

    @Test
    @Transactional
    fun getArticleTest() {
        boardService.createBoard("board1", 1)
        val articleId = articleService.createArticle("board1", "title1", "content1", OffsetDateTime.now()).id
        Assertions.assertThat(articleService.getArticle("board1", articleId).title).isEqualTo("title1")
    }

    @Test
    @Transactional
    fun modifyArticleTest() {
        val board = boardService.createBoard("board1", 1)
        val article = articleService.createArticle("board1", "title1", "content1", OffsetDateTime.now())
        articleService.modifyArticle(article.id, board, "newTitle", "newContent", OffsetDateTime.now())
        val findArticle = articleService.getArticle("board1", article.id)
        Assertions.assertThat(findArticle.title).isEqualTo("newTitle")
    }

    @Test
    @Transactional
    fun deleteArticleTest() {
        val board = boardService.createBoard("board1", 1)
        val article1 = articleService.createArticle("board1", "title1", "content1", OffsetDateTime.now())
        val article2 = articleService.createArticle("board1", "title2", "content2", OffsetDateTime.now())

        Assertions.assertThat(articleRepository.findAll().size).isEqualTo(2)
        articleService.deleteArticle("board1", article1.id)
        Assertions.assertThat(articleRepository.findAll().size).isEqualTo(1)
    }

    @Test
    @Transactional
    fun getArticleListTest() {
        val board = boardService.createBoard("board1", 1)
        val article1 = articleService.createArticle("board1", "title1", "content1", OffsetDateTime.now())
        val article2 = articleService.createArticle("board1", "title2", "content2", OffsetDateTime.now())
        val articleList = articleService.getArticleList()

        Assertions.assertThat(articleList.size).isEqualTo(2)
    }

    @Test
    @Transactional
    fun getArticleListWithBoardNameTest() {
        val board1 = boardService.createBoard("board1", 1)
        val board2 = boardService.createBoard("board2", 2)
        val article1 = articleService.createArticle("board1", "title1", "content1", OffsetDateTime.now())
        val article2 = articleService.createArticle("board1", "title2", "content2", OffsetDateTime.now())
        val article3 = articleService.createArticle("board2", "title3", "content3", OffsetDateTime.now())
        val article4 = articleService.createArticle("board2", "title4", "content4", OffsetDateTime.now())
        val article5 = articleService.createArticle("board2", "title5", "content5", OffsetDateTime.now())
        val articleList = articleService.getArticleList("board2")

        Assertions.assertThat(articleList.size).isEqualTo(3)

    }

}