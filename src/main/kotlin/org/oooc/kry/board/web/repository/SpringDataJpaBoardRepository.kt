package org.oooc.kry.board.repository

import org.oooc.kry.board.domain.dto.BoardGetResponseDTO
import org.oooc.kry.board.domain.entity.Board
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaBoardRepository: JpaRepository<Board, Long> {
    fun findByName(name: String): Board
}
