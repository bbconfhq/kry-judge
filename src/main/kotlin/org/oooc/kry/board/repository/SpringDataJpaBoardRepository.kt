package org.oooc.kry.board.repository

import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.domain.dto.BoardGetResponseDTO
import org.springframework.data.jpa.repository.JpaRepository

interface SpringDataJpaBoardRepository: JpaRepository<Board, Long>, BoardRepository {

    fun save(board: Board)

    override fun findByName(name: String): BoardGetResponseDTO

}
