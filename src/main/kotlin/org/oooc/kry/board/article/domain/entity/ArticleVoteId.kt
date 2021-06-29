package org.oooc.kry.board.domain

import java.io.Serializable

data class ArticleVoteId (
    var article: String,
    // var user: String,
    var updown: String
): Serializable
