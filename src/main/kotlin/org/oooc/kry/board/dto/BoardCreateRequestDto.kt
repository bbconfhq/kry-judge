package org.oooc.kry.board.dto

data class BoardCreateRequestDto (
    val id: Long,
    val name: String,
    val seq: Long
)
