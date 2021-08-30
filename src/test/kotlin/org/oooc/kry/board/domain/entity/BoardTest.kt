package org.oooc.kry.board.domain.entity

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.oooc.kry.board.web.service.ArticleService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@SpringBootTest
internal class BoardTest(
    @Autowired val articleService: ArticleService
) {

    val boardService = articleService.boardService

    @Test
    @Transactional
    fun 직렬화_상호참조_테스트() {
        var board = boardService.createBoard("board100", 100)
        var article1 = articleService.writeArticle("board100", "title1000", "content1000", OffsetDateTime.now())
        var article2 = articleService.writeArticle("board100", "title1001", "content1001", OffsetDateTime.now())

        var mapper = ObjectMapper()
        val jsonString1 = mapper.writeValueAsString(board)
        val jsonString2 = mapper.writeValueAsString(article1)
        val jsonString3 = mapper.writeValueAsString(article2)

        println(jsonString1)
        println(jsonString2)
        println(jsonString3)
    }
}