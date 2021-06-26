package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
data class Board (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long,

    var name: String,

    var seq: Long,



    /* for bidirectional mapping */

    @OneToMany(mappedBy = "board")
    var articles: List<Article>

)
