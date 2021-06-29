package org.oooc.kry.board.repository

import org.oooc.kry.board.domain.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.oooc.kry.board.dto.BoardGetResponseDTO

interface BoardRepository: JpaRepository<Board, Long> {

    fun save(board: Board)

    fun findByName(name: String): BoardGetResponseDTO

}
