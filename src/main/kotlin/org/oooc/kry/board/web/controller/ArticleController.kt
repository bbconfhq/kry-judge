package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.ArticleCreateRequestDTO
import org.oooc.kry.board.web.service.ArticleService
import org.springframework.web.bind.annotation.*

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
    fun getArticle() {

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
