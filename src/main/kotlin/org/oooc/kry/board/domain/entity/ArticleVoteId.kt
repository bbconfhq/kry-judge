package org.oooc.kry.board.domain.entity

import java.io.Serializable
import javax.persistence.Column

class ArticleVoteId (

    @Column(nullable = false)
    val article: Article = Article(),

    // @Column(nullable = false)
    // val user: User = User(),

    @Column(nullable = false)
    val updown: Byte = 0

): Serializable
