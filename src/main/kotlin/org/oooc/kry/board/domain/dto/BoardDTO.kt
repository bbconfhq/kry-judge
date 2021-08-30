package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Board

data class BoardPostRequestDTO(
    val name: String,
    val seq: Long
)

data class BoardPostResponseDTO(
    val id: Long,
    val name: String,
    val seq: Long
)

data class BoardGetResponseDTO(
    val id: Long,
    val name: String,
    val seq: Long,
)

data class BoardPutRequestDTO(
    val name: String,
    val seq: Long
)

data class BoardPutResponseDTO(
    val id: Long,
    val name: String,
    val seq: Long
)

data class BoardsGetResponseDTO(
    var boards: List<Board>
)