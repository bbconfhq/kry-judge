package org.oooc.kry.board.domain

import java.time.ZonedDateTime
import javax.persistence.*

@Entity
data class Article (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(columnDefinition = "INT(11) UNSIGNED")
    var board: Board,

//    TODO: Mapping to User
//    @ManyToOne
//    @JoinColumn(columnDefinition = "INT(11) UNSIGNED")
//    var user: User,

    var title: String,

    @Lob
    var content: String,

    @Temporal(TemporalType.TIMESTAMP)
    var created: ZonedDateTime,

    @Temporal(TemporalType.TIMESTAMP)
    var modified: ZonedDateTime,

    @Column(columnDefinition = "INT(11) UNSIGNED")
    var upVote: Int,

    @Column(columnDefinition = "INT(11) UNSIGNED")
    var downVote: Int,



    /* for bidirectional mapping */

    @OneToMany(mappedBy = "article")
    var comments: List<Comment>,

    )
