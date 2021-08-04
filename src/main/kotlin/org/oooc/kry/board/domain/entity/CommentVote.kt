package org.oooc.kry.board.domain.entity

import java.io.Serializable
import javax.persistence.*

@Entity
//@IdClass(CommentVoteId::class)
class CommentVote (

    @Id
    @ManyToOne
    val comment: Comment = Comment(),

//    TODO: Mapping to User
//    @ManyToOne
//    @Id
//    val user: User = User(),

    @Id
    val updown: Long = 0

): Serializable
