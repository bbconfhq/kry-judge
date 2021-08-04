package org.oooc.kry.board.web.controller

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class ArticleController {

    // CREATE ARTICLE
    @PostMapping("/{boardName}/article")
    fun postArticle() {

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
