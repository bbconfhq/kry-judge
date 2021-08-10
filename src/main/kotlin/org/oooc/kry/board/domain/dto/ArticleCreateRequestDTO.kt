package org.oooc.kry.board.domain.dto

import java.time.OffsetDateTime
import java.time.ZoneOffset

data class ArticleCreateRequestDTO (
    val title: String,
    val content: String,
    val created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00"))
)