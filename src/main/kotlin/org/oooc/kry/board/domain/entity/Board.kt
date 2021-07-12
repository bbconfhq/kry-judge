package org.oooc.kry.board.domain.entity

import org.oooc.kry.board.article.domain.entity.Article
import javax.persistence.*

@Entity
class Board (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val seq: Long = 0,



    /* for bidirectional mapping */

    @OneToMany(mappedBy = "board")
    @Column(nullable = false)
    val articles: List<Article> = emptyList()

)
