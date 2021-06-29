package org.oooc.kry.board.article.comment.domain.entity

import java.io.Serializable

data class CommentVoteId (
    var comment: Comment,
    // var user: User,
    var updown: Byte
): Serializable
