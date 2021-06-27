package org.oooc.kry.board.service

import org.oooc.kry.board.dto.BoardCreateRequestDTO
import org.oooc.kry.board.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(val boardRepository: BoardRepository) {

    fun createBoard(boardCreateRequestDTO: BoardCreateRequestDTO) {
        boardRepository.save(boardCreateRequestDTO.toEntity())
    }

}
