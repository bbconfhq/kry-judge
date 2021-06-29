package org.oooc.kry.board.domain

import javax.persistence.*

@Entity
data class Board (

    var name: String,

    var seq: Long,

) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    /* for bidirectional mapping */

    @OneToMany(mappedBy = "board")
    var articles: List<Article> = ArrayList()

}
