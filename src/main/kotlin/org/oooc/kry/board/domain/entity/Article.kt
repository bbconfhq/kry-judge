package org.oooc.kry.board.domain.entity

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import org.oooc.kry.global.json.OffsetDateTimeCustomDeserializer
import org.oooc.kry.global.json.OffsetDateTimeCustomSerializer
import java.io.Serializable
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
class Article (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    var board: Board = Board(),

//    TODO: Mapping to User
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    val user: User = User(),

    @Column(nullable = false, columnDefinition = "varchar(191)")
    var title: String = "",

    @Column(nullable = false, columnDefinition = "text")
    var content: String = "",

    @JsonProperty("created")
    @JsonSerialize(using = OffsetDateTimeCustomSerializer::class)
    @JsonDeserialize(using = OffsetDateTimeCustomDeserializer::class)
    @Column(nullable = false)
    var created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),

    @JsonProperty("modified")
    @JsonSerialize(using = OffsetDateTimeCustomSerializer::class)
    @JsonDeserialize(using = OffsetDateTimeCustomDeserializer::class)
    @Column(nullable = false)
    var modified: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),

    @Column(nullable = false)
    var upvote: Long = 0,

    @Column(nullable = false)
    var downvote: Long = 0,



    /* for bidirectional mapping */

    @JsonManagedReference
    @OneToMany(mappedBy = "article")
    var comments: MutableList<Comment> = mutableListOf(),

    @JsonManagedReference
    @OneToMany(mappedBy = "article")
    var articleVotes: MutableList<ArticleVote> = mutableListOf()

) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Article

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}