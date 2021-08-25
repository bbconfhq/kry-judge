package org.oooc.kry.board.web.repository

import org.oooc.kry.board.domain.entity.Article
import org.springframework.data.jpa.repository.JpaRepository

interface ArticleRepository : JpaRepository<Article, Long> {

}