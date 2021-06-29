package org.oooc.kry.board.dto

import org.oooc.kry.board.domain.Board

data class BoardCreateRequestDTO (
    val name: String,
    val seq: Long
) {
    fun toEntity(): Board {
        return Board(name, seq)
    }
}
