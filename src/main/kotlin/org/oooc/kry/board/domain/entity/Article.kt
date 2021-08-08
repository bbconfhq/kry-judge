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
    @JoinColumn(name = "board_id")
    val board: Board = Board(),

//    TODO: Mapping to User
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    val user: User = User(),

    @Column(nullable = false, columnDefinition = "varchar(191)")
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
    val comments: List<Comment> = emptyList(),

    @OneToMany(mappedBy = "article_vote")
    val articleVotes: List<ArticleVote> = emptyList()

): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Article

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}