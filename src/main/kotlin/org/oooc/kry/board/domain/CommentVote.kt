package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
data class CommentVote (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne
    @JoinColumn(columnDefinition = "INT(11) UNSIGNED")
    var comment: Comment,

//    TODO: Mapping to User
//    @ManyToOne
//    @JoinColumn(columnDefinition = "INT(11) UNSIGNED")
//    var user: User = User(),

    var updown: Int

)
