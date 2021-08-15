package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.entity.ArticleVote
import org.oooc.kry.board.web.repository.ArticleVoteRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ArticleVoteService(val articleVoteRepository: ArticleVoteRepository,
                         val articleService: ArticleService,
                         val boardService: BoardService
) {

    fun createArticleVote(boardName: String, articleNo: Long, updown: Byte) {
        val article = articleService.getArticle(boardName, articleNo)
        val articleVote = ArticleVote(article = article, updown = updown)
        article.articleVotes.add(articleVote)
        articleVoteRepository.save(articleVote)
    }

    fun deleteArticleVote(boardName: String, articleNo: Long, updown: Byte) {
        val article = articleService.getArticle(boardName, articleNo)
        val articleVote = ArticleVote(article = article, updown = updown)
        article.articleVotes.remove(articleVote)
        articleVoteRepository.delete(articleVote)
    }

}