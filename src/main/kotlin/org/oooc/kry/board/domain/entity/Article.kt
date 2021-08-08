package org.oooc.kry.board.domain.entity

import java.io.Serializable
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
class Article (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    val board: Board = Board(),

//    TODO: Mapping to User
//    @ManyToOne
//    val user: User = User(),

    val title: String = "",

    @Column(nullable = false, columnDefinition = "text")
    val content: String = "",

    @Column(nullable = false)
    val created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),

    @Column(nullable = false)
    val modified: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),

    @Column(nullable = false)
    val upvote: Long = 0,

    @Column(nullable = false)
    val downvote: Long = 0,



    /* for bidirectional mapping */

    @OneToMany(mappedBy = "article")
    @Column(nullable = false)
    val comments: List<Comment> = emptyList()

): Serializable
