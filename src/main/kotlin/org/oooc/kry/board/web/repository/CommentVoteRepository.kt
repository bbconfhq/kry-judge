package org.oooc.kry.board.web.repository

import org.oooc.kry.board.domain.entity.CommentVote
import org.oooc.kry.board.domain.entity.CommentVoteId
import org.springframework.data.jpa.repository.JpaRepository

interface CommentVoteRepository : JpaRepository<CommentVote, CommentVoteId> {

}