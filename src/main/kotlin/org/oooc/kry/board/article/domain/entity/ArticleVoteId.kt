package org.oooc.kry.board.article.domain.entity

import java.io.Serializable

data class ArticleVoteId (
    var article: String,
    // var user: String,
    var updown: String
): Serializable
