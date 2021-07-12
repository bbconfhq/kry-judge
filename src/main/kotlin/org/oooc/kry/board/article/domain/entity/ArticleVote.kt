package org.oooc.kry.board.article.domain.entity

import javax.persistence.*

@Entity
@IdClass(ArticleVoteId::class)
class ArticleVote (

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    val article: Article = Article(),

//    TODO: Mapping to User
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    val user: User = User(),

    @Id
    val updown: Byte = 0

)
