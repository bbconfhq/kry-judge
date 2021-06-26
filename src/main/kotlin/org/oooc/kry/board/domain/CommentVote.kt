package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
data class CommentVote (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne
    var comment: Comment,

//    TODO: Mapping to User
//    @ManyToOne
//    var user: User = User(),

    var updown: Long

)
