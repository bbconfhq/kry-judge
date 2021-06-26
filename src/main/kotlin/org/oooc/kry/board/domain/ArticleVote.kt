package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
data class ArticleVote (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    var article: Article,

//    TODO: Mapping to User
//    @ManyToOne(fetch = FetchType.LAZY)
//    var user: User,

    var updown: Long

)
