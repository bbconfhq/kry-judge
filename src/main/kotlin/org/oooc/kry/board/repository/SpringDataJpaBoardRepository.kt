package org.oooc.kry.board.repository

import org.oooc.kry.board.domain.Board
import org.oooc.kry.board.dto.BoardGetResponseDTO
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaBoardRepository: JpaRepository<Board, Long>, BoardRepository {

    fun save(board: Board)

    override fun findByName(name: String): BoardGetResponseDTO

}
