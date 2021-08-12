package org.oooc.kry.board.web.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@SpringBootTest
class CommentServiceTest(
    @Autowired val commentService: CommentService
) {
    val commentRepository = commentService.commentRepository
    val boardService = commentService.boardService
    val articleService = commentService.articleService

    @Test
    @Transactional
    fun createCommentTest() {
        boardService.createBoard("board1", 1)
        val article = articleService.createArticle(boardName = "board1", title = "title1", content = "content1", created = OffsetDateTime.now())
        commentService.createComment("board1", article.id, "commentContent1", OffsetDateTime.now())

        Assertions.assertThat(commentRepository.count()).isEqualTo(1)
    }

    @Test
    @Transactional
    fun getCommentTest() {
        boardService.createBoard("board1", 1)
        val article = articleService.createArticle(boardName = "board1", title = "title1", content = "content1", created = OffsetDateTime.now())
        val comment = commentService.createComment("board1", article.id, "commentContent1", OffsetDateTime.now())

        Assertions.assertThat(commentService.getComment("board1", article.id, comment.id).content).isEqualTo("commentContent1")
    }

    @Test
    @Transactional
    fun deleteCommentTest() {
        boardService.createBoard("board1", 1)
        val article = articleService.createArticle(boardName = "board1", title = "title1", content = "content1", created = OffsetDateTime.now())
        val comment1 = commentService.createComment("board1", article.id, "commentContent1", OffsetDateTime.now())
        val comment2 = commentService.createComment("board1", article.id, "commentContent1", OffsetDateTime.now())
        val comment3 = commentService.createComment("board1", article.id, "commentContent1", OffsetDateTime.now())
        commentService.deleteComment("board1", article.id, comment3.id)

        Assertions.assertThat(commentRepository.count()).isEqualTo(2)
    }

    @Test
    @Transactional
    fun getCommentsListTest() {
        boardService.createBoard("board1", 1)
        val article1 = articleService.createArticle(boardName = "board1", title = "title1", content = "content1", created = OffsetDateTime.now())
        val article2 = articleService.createArticle(boardName = "board1", title = "title1", content = "content1", created = OffsetDateTime.now())
        val comment1 = commentService.createComment("board1", article1.id, "commentContent1", OffsetDateTime.now())
        val comment2 = commentService.createComment("board1", article1.id, "commentContent2", OffsetDateTime.now())
        val comment3 = commentService.createComment("board1", article2.id, "commentContent3", OffsetDateTime.now())

        Assertions.assertThat(commentService.getCommentsList("board1", article1.id).size).isEqualTo(2)
        Assertions.assertThat(commentService.getCommentsList("board1", article2.id).size).isEqualTo(1)
    }
}