package org.oooc.kry.board.web.service

import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.exception.BoardNotFoundException
import org.oooc.kry.board.web.repository.BoardRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class BoardService(
    val boardRepository: BoardRepository
) {
    fun createBoard(
        name: String,
        seq: Long
    ): Board {
        val board = Board(
            name = name,
            seq = seq
        )
        return boardRepository.save(board)
    }

    fun getBoard(
        name: String
    ): Board {
        return boardRepository.findByName(name) ?: throw BoardNotFoundException()
    }

    fun modifyBoard(
        name: String,
        newName: String,
        newSeq: Long
    ): Board {
        val board = boardRepository.findByName(name) ?: throw BoardNotFoundException()
        board.name = newName
        board.seq = newSeq
        return boardRepository.saveAndFlush(board)
    }

    fun deleteBoard(
        name: String
    ) {
        val board = boardRepository.findByName(name) ?: throw BoardNotFoundException()
        boardRepository.delete(board)
    }

    fun getBoardList(): List<Board> {
        return boardRepository.findAll()
    }
}
