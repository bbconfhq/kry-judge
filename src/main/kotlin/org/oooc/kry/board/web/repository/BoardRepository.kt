package org.oooc.kry.board.web.repository

import org.oooc.kry.board.domain.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface BoardRepository: JpaRepository<Board, Long> {
    fun findByName(name: String): Board
}