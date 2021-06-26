package org.oooc.kry.board.service

import org.oooc.kry.board.dto.BoardCreateRequestDto
import org.oooc.kry.board.repository.BoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(val boardRepository: BoardRepository) {
    fun createBoard(boardCreateRequestDto: BoardCreateRequestDto) {
        boardRepository.save()
    }

}
