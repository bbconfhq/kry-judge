package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
@IdClass(ArticleVoteId::class)
data class ArticleVote (

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    var article: Article,

//    TODO: Mapping to User
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    var user: User,

    @Id
    var updown: Byte

)
