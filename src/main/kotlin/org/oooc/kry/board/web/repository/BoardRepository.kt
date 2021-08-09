package org.oooc.kry.board.web.repository

import org.oooc.kry.board.domain.entity.Board

interface BoardRepository {
    fun save(board: Board)
    fun delete(board: Board)
    fun findByName(name: String): Board
}