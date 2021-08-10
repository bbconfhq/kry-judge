package org.oooc.kry.board.web.repository

import org.oooc.kry.board.domain.entity.Article

interface ArticleRepository {
    fun save(article: Article)
}