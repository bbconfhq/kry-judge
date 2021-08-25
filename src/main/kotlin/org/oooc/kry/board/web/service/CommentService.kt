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
    fun createComment(
        boardName: String,
        articleNo: Long,
        content: String,
        created: OffsetDateTime
    ): Comment {
        val article = articleService.getArticle(boardName, articleNo)
        val comment = Comment(article = article,
            content = content,
            created = created,
        )
        article.comments.add(comment)
        return commentRepository.save(comment)
    }

    fun getComment(
        boardName: String,
        articleNo: Long,
        commentNo: Long
    ): Comment {
        return commentRepository.findById(commentNo).get()
    }

    fun deleteComment(
        boardName: String,
        articleNo: Long,
        commentNo: Long
    ) {
        val article = articleService.getArticle(boardName, articleNo)
        val comment = commentRepository.findById(commentNo).get()
        commentRepository.deleteById(commentNo)
        article.comments.remove(comment)
    }

    fun getCommentsList(
        boardName: String,
        articleNo: Long
    ): MutableList<Comment> {
        val article = articleService.getArticle(boardName, articleNo)
        return article.comments
    }
}