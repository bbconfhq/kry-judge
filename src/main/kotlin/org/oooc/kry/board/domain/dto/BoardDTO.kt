package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Board
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

data class BoardPostRequestDTO(
    @field:NotEmpty val name: String,
    @field:NotNull val seq: Long
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
    @field:NotEmpty val name: String,
    @field:NotNull val seq: Long
)

data class BoardPutResponseDTO(
    val id: Long,
    val name: String,
    val seq: Long
)

data class BoardsGetResponseDTO(
    var boards: List<Board>
)