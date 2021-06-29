package org.oooc.kry.board.domain.entity

import org.oooc.kry.board.article.domain.entity.Article
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
