package org.oooc.kry.board.domain.entity

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.oooc.kry.board.web.service.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@SpringBootTest
internal class CommentTest(
    @Autowired val commentVoteService: CommentVoteService
) {
    val commentService = commentVoteService.commentService
    val articleService = commentService.articleService
    val boardService = commentService.boardService

    @Test
    @Transactional
    fun article_board_serialize_test() {
        boardService.createBoard("board1", 100)
        val article1 = articleService.writeArticle("board1", "title1", "content1", OffsetDateTime.now())
        val article2 = articleService.writeArticle("board1", "title2", "content2", OffsetDateTime.now())
        val comment1 = commentService.writeComment("board1", article1.id, "commentContent1", OffsetDateTime.now())
        val commentVote1 = commentVoteService.createCommentVote("board1", article1.id, comment1.id, 1)

        var mapper = ObjectMapper()
        val jsonString1 = mapper.writeValueAsString(article1)
        val jsonString2 = mapper.writeValueAsString(comment1)
        val jsonString3 = mapper.writeValueAsString(commentVote1)

        println(jsonString1)
        println("********************")
        println(jsonString2)
        println("********************")
        println(jsonString3)
    }

}