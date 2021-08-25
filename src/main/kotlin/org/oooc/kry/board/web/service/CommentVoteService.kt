package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.entity.CommentVote
import org.oooc.kry.board.web.repository.CommentVoteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class CommentVoteService (
    val boardService: BoardService,
    val articleService: ArticleService,
    val commentService: CommentService,
    val commentVoteRepository: CommentVoteRepository
){
    fun createCommentVote(
        boardName: String,
        articleNo: Long,
        commentNo: Long,
        updown: Byte
    ): CommentVote {
        val comment = commentService.getComment(boardName, articleNo, commentNo)
        val commentVote = CommentVote(comment, updown)
        comment.commentVotes.add(commentVote)
        return commentVoteRepository.save(commentVote)
    }

    fun deleteCommentVote(
        boardName: String,
        articleNo: Long,
        commentNo: Long,
        updown: Byte
    ) {
        val comment = commentService.getComment(boardName, articleNo, commentNo)
        val commentVote = CommentVote(comment, updown)
        comment.commentVotes.remove(commentVote)
        commentVoteRepository.delete(commentVote)
    }
}