package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.entity.Article
import org.oooc.kry.board.domain.entity.ArticleVoteId
import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.web.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime
import java.util.*

@Service
@Transactional
class ArticleService(
    val articleRepository: ArticleRepository,
    val boardService: BoardService
) {
    fun createArticle(boardName: String, title: String, content: String, created: OffsetDateTime): Article {
        val board = boardService.getBoard(boardName)
        val article = Article(board = board,
            title = title,
            content = content,
            created = created
        )
        board.articles.add(article)
        return articleRepository.save(article)
    }

    fun getArticle(boardName: String, articleNo: Long): Article {
        return articleRepository.findById(articleNo).get()
    }

    fun modifyArticle(articleNo: Long, board: Board, title: String, content: String, modified: OffsetDateTime) {
        val article = articleRepository.findById(articleNo).get()
        article.board = board
        article.title = title
        article.content = content
        article.modified = modified
    }

    fun deleteArticle(boardName: String, articleNo: Long) {
        val board = boardService.getBoard(boardName)
        val article = articleRepository.findById(articleNo).get()
        articleRepository.delete(article)
        board.articles.remove(article)
    }

    fun getArticleList(): List<Article> {
        return articleRepository.findAll()
    }

}