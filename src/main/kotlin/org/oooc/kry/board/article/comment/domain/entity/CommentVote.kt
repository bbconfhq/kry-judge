package org.oooc.kry.board.article.comment.domain.entity

import javax.persistence.*

@Entity
@IdClass(CommentVoteId::class)
data class CommentVote (

    @Id
    @ManyToOne
    @JoinColumn
    var comment: Comment,

//    TODO: Mapping to User
//    @ManyToOne
//    @Id
//    var user: User = User(),

    @Id
    var updown: Long

)
