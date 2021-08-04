package org.oooc.kry.board.article.comment.domain.entity

import java.io.Serializable
import javax.persistence.Column

class CommentVoteId (

    @Column(nullable = false)
    val comment: Comment,

    // @Column(nullable = false)
    // val user: User,

    @Column(nullable = false)
    val updown: Byte

): Serializable
