package org.oooc.kry.board.service

import org.oooc.kry.board.dto.BoardCreateRequestDTO
import org.oooc.kry.board.dto.BoardGetRequestDTO
import org.oooc.kry.board.dto.BoardGetResponseDTO
import org.springframework.stereotype.Service
import org.oooc.kry.board.repository.SpringDataJpaBoardRepository

@Service
class BoardService(val boardRepository: SpringDataJpaBoardRepository) {

    fun createBoard(boardCreateRequestDTO: BoardCreateRequestDTO) {
        boardRepository.save(boardCreateRequestDTO.toEntity())
    }

    fun getBoard(boardGetRequestDTO: BoardGetRequestDTO): BoardGetResponseDTO {
        val boardName = boardGetRequestDTO.boardName
        return boardRepository.findByName(boardName)
    }

}
