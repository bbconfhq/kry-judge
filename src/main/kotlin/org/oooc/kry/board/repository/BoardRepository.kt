package org.oooc.kry.board.repository

import org.oooc.kry.board.domain.entity.Board
import org.springframework.data.jpa.repository.JpaRepository
import org.oooc.kry.board.domain.dto.BoardGetResponseDTO

interface BoardRepository: JpaRepository<Board, Long> {

    fun findByName(name: String): BoardGetResponseDTO

}
