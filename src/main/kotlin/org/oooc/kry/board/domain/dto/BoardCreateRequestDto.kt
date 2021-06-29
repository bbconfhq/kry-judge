package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Board

data class BoardCreateRequestDTO (
    val name: String,
    val seq: Long
) {
    fun toEntity(): Board {
        return Board(name, seq)
    }
}
