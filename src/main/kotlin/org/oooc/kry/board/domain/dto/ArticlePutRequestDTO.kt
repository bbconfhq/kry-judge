package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Board
import java.time.OffsetDateTime
import java.time.ZoneOffset

data class ArticlePutRequestDTO (
    val board: Board = Board(),
//    val user: User = User(),
    val title: String = "",
    val content: String = "",
    val modified: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),
)