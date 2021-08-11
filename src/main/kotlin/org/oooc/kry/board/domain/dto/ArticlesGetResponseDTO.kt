package org.oooc.kry.board.domain.dto

import org.oooc.kry.board.domain.entity.Article

data class ArticlesGetResponseDTO (
    var articles: List<Article>
)