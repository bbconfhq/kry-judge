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
    @JoinColumn(columnDefinition = "INT(11) UNSIGNED")
    var article: Article,

//    TODO: Mapping to User
//    @ManyToOne
//    @JoinColumn(columnDefinition = "INT(11) UNSIGNED")
//    var user: User

    @Lob
    var content: String,

    var created: OffsetDateTime,

    var modified: OffsetDateTime,

    @Column(columnDefinition = "INT(11) UNSIGNED")
    var upVote: Int,

    @Column(columnDefinition = "INT(11) UNSIGNED")
    var downVote: Int

)
