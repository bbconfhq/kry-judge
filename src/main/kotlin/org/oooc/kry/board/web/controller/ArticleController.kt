package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.ArticleCreateRequestDTO
import org.oooc.kry.board.domain.dto.ArticleGetResponseDTO
import org.oooc.kry.board.domain.dto.ArticlePutRequestDTO
import org.oooc.kry.board.domain.dto.ArticlesGetResponseDTO
import org.oooc.kry.board.web.service.ArticleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class ArticleController(
    val articleService: ArticleService
) {

    // CREATE ARTICLE
    @PostMapping("/{boardName}/article")
    fun postArticle(
        @PathVariable boardName: String,
        @RequestBody articleCreateRequestDTO: ArticleCreateRequestDTO
    ) {
        articleService.createArticle(boardName,
            articleCreateRequestDTO.title,
            articleCreateRequestDTO.content,
            articleCreateRequestDTO.created)
    }

    // GET ARTICLE
    @GetMapping("/{boardName}/article/{articleNo}")
    fun getArticle(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long
    ): ArticleGetResponseDTO {
        val article = articleService.getArticle(boardName, articleNo)
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
    }

    // MODIFY ARTICLE
    @PutMapping("/{boardName}/article/{articleNo}")
    fun putArticle(
        @PathVariable articleNo: Long,
        @RequestBody articlePutRequestDTO: ArticlePutRequestDTO
    ) {
        articleService.modifyArticle(articleNo,
            articlePutRequestDTO.board,
            articlePutRequestDTO.title,
            articlePutRequestDTO.content,
            articlePutRequestDTO.modified
        )
    }

    // DELETE ARTICLE
    @DeleteMapping("/{boardName}/article/{articleNo}")
    fun deleteArticle(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long)
    {
        articleService.deleteArticle(boardName, articleNo)
    }

    // GET LIST OF ARTICLES
    @GetMapping("/{boardName}/article")
    fun getArticles(): ArticlesGetResponseDTO {
        val articlesList = articleService.getArticleList()
        return ArticlesGetResponseDTO(articlesList)
    }

}
