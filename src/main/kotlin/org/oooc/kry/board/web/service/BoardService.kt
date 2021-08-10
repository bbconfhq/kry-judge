package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.dto.BoardCreateRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetResponseDTO
import org.oooc.kry.board.domain.dto.BoardPutRequestDTO
import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.web.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BoardService(val boardRepository: BoardRepository) {

    fun createBoard(name: String, seq: Long) {
        val board = Board(name=name, seq=seq)
        boardRepository.save(board)
    }

    fun getBoard(name: String): Board {
        return boardRepository.findByName(name)
    }

    fun modifyBoard(name: String, newName: String, newSeq: Long) {
        var board = boardRepository.findByName(name)
        if (board != null) {
            board.name = newName
        }
    }

    fun deleteBoard(name: String) {
        var board = boardRepository.findByName(name)
        if (board != null) {
            boardRepository.delete(board)
        }
    }

    fun getBoardList(): List<Board> {
        return boardRepository.findAll()
    }

}
