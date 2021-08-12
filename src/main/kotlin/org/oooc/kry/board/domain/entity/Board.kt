package org.oooc.kry.board.domain.entity

import java.io.Serializable
import javax.persistence.*

@Entity
class Board (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var seq: Long = 0,



    /* for bidirectional mapping */

    @OneToMany(mappedBy = "board")
    var articles: MutableList<Article> = mutableListOf()

): Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Board

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}