package org.oooc.kry.board.domain

import java.time.OffsetDateTime
import java.time.ZonedDateTime
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
