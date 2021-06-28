package org.oooc.kry.board.repository

import org.oooc.kry.board.dto.BoardGetResponseDTO

interface BoardRepository {

    fun findByName(name: String): BoardGetResponseDTO

}