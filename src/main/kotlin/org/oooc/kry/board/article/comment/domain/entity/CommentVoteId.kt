package org.oooc.kry.board.domain

import java.io.Serializable

data class CommentVoteId (
    var comment: String,
    var user: String,
    var updown: String
): Serializable
