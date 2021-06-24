package org.oooc.kry.board.service

import org.oooc.kry.board.repository.JpaBoardRepository
import org.springframework.stereotype.Service

@Service
class BoardService(val boardRepository: JpaBoardRepository) {

    fun getBoards() {
        boardRepository.getBoardList()
    }

}