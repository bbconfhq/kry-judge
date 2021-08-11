package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.dto.BoardCreateRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetResponseDTO
import org.oooc.kry.board.domain.dto.BoardPutRequestDTO
import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.web.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.math.E

@Service
@Transactional
class BoardService(val boardRepository: BoardRepository) {

    fun createBoard(name: String, seq: Long): Board {
        val board = Board(name=name, seq=seq)
        return boardRepository.save(board)
    }

    fun getBoard(name: String): Board {
        return boardRepository.findByName(name).get()
    }

    fun modifyBoard(name: String, newName: String, newSeq: Long) {
        var board = boardRepository.findByName(name).get()
        board.name = newName
        board.seq = newSeq
    }

    fun deleteBoard(name: String) {
        var board = boardRepository.findByName(name).get()
        boardRepository.delete(board)
    }

    fun getBoardList(): List<Board> {
        return boardRepository.findAll()
    }

}
