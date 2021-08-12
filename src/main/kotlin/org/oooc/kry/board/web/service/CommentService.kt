package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.entity.Comment
import org.oooc.kry.board.web.repository.CommentRepository
import org.springframework.stereotype.Service
import java.time.OffsetDateTime

@Service
class CommentService(
    val boardService: BoardService,
    val articleService: ArticleService,
    val commentRepository: CommentRepository
) {

    fun createComment(boardName: String, articleNo: Long, content: String, created: OffsetDateTime) {
        val article = articleService.getArticle(boardName, articleNo)
        val comment = Comment(article = article,
            content = content,
            created = created,
        )
        commentRepository.save(comment)
    }

}