package org.oooc.kry.board.article.domain.entity

import java.io.Serializable

data class ArticleVoteId (
    var article: Article,
    // var user: User,
    var updown: Byte
): Serializable
