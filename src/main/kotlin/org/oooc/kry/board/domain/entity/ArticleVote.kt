package org.oooc.kry.board.domain.entity

import java.io.Serializable
import javax.persistence.*

class ArticleVoteId (
    val article: Article = Article(),
    // val user: User = User(),
    val updown: Byte = 0
): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ArticleVoteId

        if (article != other.article) return false
        if (updown != other.updown) return false

        return true
    }

    override fun hashCode(): Int {
        var result = article.hashCode()
        result = 31 * result + updown.hashCode()
        return result
    }
}

@Entity
@IdClass(ArticleVoteId::class)
class ArticleVote (

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "article_id")
    val article: Article = Article(),

//    TODO: Mapping to User
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    val user: User = User(),

    @Id
    val updown: Byte = 0

): Serializable
