package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.entity.Article
import org.oooc.kry.board.web.repository.ArticleRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime

@Service
@Transactional
class ArticleService(
    val articleRepository: ArticleRepository,
    val boardService: BoardService
) {
    fun createArticle(boardName: String, title: String, content: String, created: OffsetDateTime) {
        val board = boardService.getBoard(boardName)
        val article = Article(board = board,
            title = title,
            content = content,
            created = created
        )
        articleRepository.save(article)
    }

    fun getArticle(boardName: String, articleNo: Long) {
        
    }

}