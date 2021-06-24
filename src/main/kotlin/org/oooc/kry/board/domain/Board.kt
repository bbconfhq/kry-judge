package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
data class Board (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT(11) UNSIGNED")
    var id: Long,

    var name: String,

    @Column(columnDefinition = "INT(11) UNSIGNED")
    var seq: Int,



    /* for bidirectional mapping */

    @OneToMany(mappedBy = "board")
    var articles: List<Article>

)
