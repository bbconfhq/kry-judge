package org.oooc.kry.board.service

import org.oooc.kry.board.domain.dto.BoardCreateRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetResponseDTO
import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.repository.SpringDataJpaBoardRepository
import org.springframework.stereotype.Service
import org.springframework.beans.factory.annotation.Autowired

@Service
class BoardService(val boardRepository: SpringDataJpaBoardRepository) {



    fun createBoard(boardCreateRequestDTO: BoardCreateRequestDTO) {
        boardRepository.save(boardCreateRequestDTO.toEntity())
    }

    fun getBoard(boardGetRequestDTO: BoardGetRequestDTO): BoardGetResponseDTO {
        val boardName = boardGetRequestDTO.boardName
        val board: Board = boardRepository.findByName(boardName)
        return BoardGetResponseDTO(id = board.id, name = board.name, seq = board.seq)
    }

}
