package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Article

data class BoardGetResponseDTO (
    val id: Long,
    val name: String,
    val seq: Long,
    // TODO: return must include articles
    val articles: List<Article>
)
