package org.oooc.kry.board.article.comment.domain.entity

import org.oooc.kry.board.article.domain.entity.Article
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
data class Comment (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    var article: Article,

//    TODO: Mapping to User
//    @ManyToOne
//    var user: User

    @Lob
    var content: String,

    var created: OffsetDateTime,

    var modified: OffsetDateTime,

    var upVote: Long,

    var downVote: Long

)
