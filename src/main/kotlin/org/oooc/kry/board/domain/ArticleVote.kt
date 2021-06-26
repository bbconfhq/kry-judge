package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
data class ArticleVote (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "INT(11) UNSIGNED")
    var article: Article,

//    TODO: Mapping to User
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(columnDefinition = "INT(11) UNSIGNED")
//    var user: User,

    var updown: Int

)
