package org.oooc.kry.board.domain.entity

import org.oooc.kry.board.domain.entity.Article
import java.io.Serializable
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
class Comment (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    val article: Article = Article(),

//    TODO: Mapping to User
//    @ManyToOne
//    val user: User = User()

    @Column(nullable = false, columnDefinition = "text")
    val content: String = "",

    @Column(nullable = false)
    val created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+09:00")),

    @Column(nullable = false)
    val modified: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+09:00")),

    @Column(nullable = false)
    val upVote: Long = 0,

    @Column(nullable = false)
    val downVote: Long = 0

): Serializable
