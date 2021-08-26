package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.*
import org.oooc.kry.board.web.service.ArticleService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
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
    ): APIResponse<ArticleCreateResponseDTO> {
        val article = articleService.createArticle(
            boardName,
            articleCreateRequestDTO.title,
            articleCreateRequestDTO.content,
            articleCreateRequestDTO.created
        )
        val respDTO = ArticleCreateResponseDTO(
            article.id,
            article.board.name,
            article.title,
            article.content,
            article.created,
            article.modified,
            article.upvote,
            article.downvote
        )
        return APIResponse(
            data = respDTO
        )
    }

    // GET ARTICLE
    @GetMapping("/{boardName}/article/{articleNo}")
    fun getArticle(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long
    ): APIResponse<ArticleGetResponseDTO> {
        val article = articleService.getArticle(boardName, articleNo)
        val respDTO = ArticleGetResponseDTO(
            id = article.id,
            boardName = article.board.name,
            title = article.title,
            content = article.content,
            created = article.created,
            modified = article.modified,
            upvote = article.upvote,
            downvote = article.downvote,
            comments = article.comments
        )
        return APIResponse(
            data = respDTO
        )
    }

    // MODIFY ARTICLE
    @PutMapping("/{boardName}/article/{articleNo}")
    fun putArticle(
        @PathVariable articleNo: Long,
        @RequestBody articlePutRequestDTO: ArticlePutRequestDTO
    ): APIResponse<ArticlePutResponseDTO> {
        val article = articleService.modifyArticle(
            articleNo,
            articlePutRequestDTO.board,
            articlePutRequestDTO.title,
            articlePutRequestDTO.content,
            articlePutRequestDTO.modified
        )
        val respDTO = ArticlePutResponseDTO(
            id = article.id,
            boardName = article.board.name,
            title = article.title,
            content = article.content,
            created = article.created,
            modified = article.modified,
            upvote = article.upvote,
            downvote = article.downvote
        )
        return APIResponse(
            data = respDTO
        )
    }

    // DELETE ARTICLE
    @DeleteMapping("/{boardName}/article/{articleNo}")
    fun deleteArticle(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long
    ): APIResponse<CheckDTO> {
        articleService.deleteArticle(boardName, articleNo)
        return APIResponse(
            data = CheckDTO(
                success = true)
        )
    }

    // GET LIST OF ARTICLES
    @GetMapping("/{boardName}/article")
    fun getArticles(
        @PathVariable boardName: String
    ): APIResponse<ArticlesGetResponseDTO> {
        val articlesList = articleService.getArticleList(boardName)
        val respDTO = ArticlesGetResponseDTO(articlesList)
        return APIResponse(
            data = respDTO
        )
    }

}
