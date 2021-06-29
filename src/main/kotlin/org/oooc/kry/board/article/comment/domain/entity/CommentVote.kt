package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
@IdClass(CommentVoteId::class)
data class CommentVote (

    @Id
    @ManyToOne
    var comment: Comment,

//    TODO: Mapping to User
//    @ManyToOne
//    @Id
//    var user: User = User(),

    @Id
    var updown: Long

)
