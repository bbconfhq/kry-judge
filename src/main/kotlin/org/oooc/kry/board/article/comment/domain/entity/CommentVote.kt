package org.oooc.kry.board.article.comment.domain.entity

import javax.persistence.*

@Entity
@IdClass(CommentVoteId::class)
class CommentVote (

    @Id
    @ManyToOne
    @JoinColumn
    val comment: Comment = Comment(),

//    TODO: Mapping to User
//    @ManyToOne
//    @Id
//    val user: User = User(),

    @Id
    val updown: Long = 0

)
