package org.oooc.kry.board.article.comment.domain.entity

import org.oooc.kry.board.article.domain.entity.Article
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
class Comment (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(nullable = false)
    val article: Article = Article(),

//    TODO: Mapping to User
//    @ManyToOne
//    val user: User = User()

    @Lob
    @Column(nullable = false)
    val content: String = "",

    @Column(nullable = false)
    val created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+09:00")),

    @Column(nullable = false)
    val modified: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+09:00")),

    @Column(nullable = false)
    val upVote: Long = 0,

    @Column(nullable = false)
    val downVote: Long = 0

)
