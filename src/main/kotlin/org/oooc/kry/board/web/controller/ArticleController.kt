package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.ArticleCreateRequestDTO
import org.oooc.kry.board.domain.dto.ArticleGetResponseDTO
import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.domain.entity.Comment
import org.oooc.kry.board.web.service.ArticleService
import org.springframework.web.bind.annotation.*
import java.time.OffsetDateTime

@RestController
@RequestMapping("board")
class ArticleController(val articleService: ArticleService) {

    // CREATE ARTICLE
    @PostMapping("/{boardName}/article")
    fun postArticle(@PathVariable boardName: String, @RequestBody articleCreateRequestDTO: ArticleCreateRequestDTO) {
        articleService.createArticle(boardName,
            articleCreateRequestDTO.title,
            articleCreateRequestDTO.content,
            articleCreateRequestDTO.created)
    }

    // GET ARTICLE
    @GetMapping("/{boardName}/article/{articleNo}")
    fun getArticle(@PathVariable boardName: String, @PathVariable articleNo: Long): ArticleGetResponseDTO {
        val res = articleService.getArticle(boardName, articleNo)
        if (res.isPresent) {
            val article = res.get()
            return ArticleGetResponseDTO(id = article.id,
                board = article.board,
                title = article.title,
                content = article.content,
                created = article.created,
                modified = article.modified,
                upvote = article.upvote,
                downvote = article.downvote,
                comments = article.comments
            )
        } else {
            // TODO: throw exception
            return ArticleGetResponseDTO(id = 0,
                board = Board(),
                title = "",
                content = "",
                created = OffsetDateTime.now(),
                modified = OffsetDateTime.now(),
                upvote = 0,
                downvote = 0,
                comments = emptyList()
            )
        }
    }

    // MODIFY ARTICLE
    @PutMapping("/{boardName}/article/{articleNo}")
    fun putArticle() {

    }

    // DELETE ARTICLE
    @DeleteMapping("/{boardName}/article/{articleNo}")
    fun deleteArticle() {

    }

    // GET LIST OF ARTICLES
    @GetMapping("/{boardName}/article")
    fun getArticles() {

    }

}
