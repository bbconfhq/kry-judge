package org.oooc.kry.board.web.repository

import org.oooc.kry.board.domain.entity.ArticleVote
import org.oooc.kry.board.domain.entity.ArticleVoteId
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleVoteRepository: JpaRepository<ArticleVote, ArticleVoteId> {

}