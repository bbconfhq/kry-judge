package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.dto.BoardCreateRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetResponseDTO
import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.web.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BoardService(val boardRepository: BoardRepository) {

    fun createBoard(boardCreateRequestDTO: BoardCreateRequestDTO) {
        boardRepository.save(boardCreateRequestDTO.toEntity())
    }

    fun getBoard(reqDTO: BoardGetRequestDTO): BoardGetResponseDTO {
        val boardName = reqDTO.boardName
        val board: Board = boardRepository.findByName(boardName)
        return BoardGetResponseDTO(id = board.id, name = board.name, seq = board.seq, articles = board.articles)
    }

}
