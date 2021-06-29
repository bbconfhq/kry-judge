package org.oooc.kry.board.article.comment.domain.entity

import java.io.Serializable

data class CommentVoteId (
    var comment: String,
    // var user: String,
    var updown: String
): Serializable
