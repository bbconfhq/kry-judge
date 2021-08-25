package org.oooc.kry.board.domain.entity

import java.io.Serializable
import javax.persistence.*

/**
 * https://www.logicbig.com/tutorials/java-ee-tutorial/jpa/id-class-with-many-to-one-relation.html
 */

class ArticleVoteId (
    var article: Long = 0,
    // val user: User = User(),
    var updown: Byte = 0
) : Serializable {
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
    var article: Article = Article(),

//    TODO: Mapping to User
//    @Id
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    val user: User = User(),

    @Id
    var updown: Byte = 0

) : Serializable
