package org.oooc.kry.board.domain

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
data class Article (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    var board: Board,

//    TODO: Mapping to User
//    @ManyToOne
//    var user: User,

    var title: String,

    @Lob
    var content: String,

    var created: OffsetDateTime,

    var modified: OffsetDateTime,

    var upvote: Long,

    var downvote: Long,



    /* for bidirectional mapping */

    @OneToMany(mappedBy = "article")
    var comments: List<Comment>

)
