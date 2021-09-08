package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.*
import org.oooc.kry.board.web.service.ArticleService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("board")
class ArticleController(
    val articleService: ArticleService
) {
    @PostMapping("/{boardName}/article")
    fun postArticle(
        @PathVariable boardName: String,
        @RequestBody @Valid articlePostRequestDTO: ArticlePostRequestDTO
    ): APIResponse<ArticlePostResponseDTO> {
        val article = articleService.writeArticle(
            boardName = boardName,
            title = articlePostRequestDTO.title,
            content = articlePostRequestDTO.content,
            created = articlePostRequestDTO.created
        )
        val respDTO = ArticlePostResponseDTO(
            id = article.id,
            board = article.board,
            title = article.title,
            content = article.content,
            created = article.created
        )
        return APIResponse(
            data = respDTO
        )
    }

    @GetMapping("/{boardName}/article/{articleNo}")
    fun getArticle(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long
    ): APIResponse<ArticleGetResponseDTO> {
        val article = articleService.getArticle(boardName, articleNo)
        val respDTO =  ArticleGetResponseDTO(
            id = article.id,
            board = article.board,
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

    @PutMapping("/{boardName}/article/{articleNo}")
    fun putArticle(
        @PathVariable articleNo: Long,
        @RequestBody @Valid articlePutRequestDTO: ArticlePutRequestDTO
    ): APIResponse<ArticlePutResponseDTO> {
        val article = articleService.modifyArticle(
            articleNo = articleNo,
            board = articlePutRequestDTO.board,
            title = articlePutRequestDTO.title,
            content = articlePutRequestDTO.content,
            modified = articlePutRequestDTO.modified
        )
        val respDTO = ArticlePutResponseDTO(
            id = article.id,
            board = article.board,
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

    @DeleteMapping("/{boardName}/article/{articleNo}")
    fun deleteArticle(
        @PathVariable boardName: String,
        @PathVariable articleNo: Long
    ): APIResponse<CheckDTO> {
        articleService.deleteArticle(boardName, articleNo)
        return APIResponse(
            data = CheckDTO(
                success = true
            )
        )
    }

    @GetMapping("/{boardName}/article")
    fun getArticles(): APIResponse<ArticlesGetResponseDTO> {
        val articles = articleService.getArticleList()
        val respDTO = ArticlesGetResponseDTO(
            articles = articles
        )
        return APIResponse(
            data = respDTO
        )
    }
}