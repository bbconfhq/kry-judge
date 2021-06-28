package org.oooc.kry.board.dto

import org.oooc.kry.board.domain.Article

data class BoardGetResponseDTO (
    val id: Long,
    val name: String,
    val seq: Long,
    val articles: List<Article>
)
