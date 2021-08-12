package org.oooc.kry.board.web.repository

import org.oooc.kry.board.domain.entity.Comment
import org.springframework.data.jpa.repository.JpaRepository

interface CommentRepository: JpaRepository<Comment, Long> {

}