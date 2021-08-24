package org.oooc.kry.problem.entity

import com.fasterxml.jackson.annotation.JsonManagedReference
import java.io.Serializable
import java.time.OffsetDateTime
import java.time.ZoneOffset
import javax.persistence.*

@Entity
class Problem(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    /**
     * TODO: Mapping to User
     * @ManyToOne
     * val user: User
     */

    @OneToMany(mappedBy = "problem")
    @JsonManagedReference
    var testcases: List<Testcase> = emptyList(),

    @Column(nullable = false, unique = true, length = 191)
    var title: String = "",

    @Column(nullable = false, columnDefinition = "text")
    var content: String = "",

    @Column(nullable = false)
    val created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),

    @Column(nullable = false)
    var modified: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+00:00")),

    @Column(nullable = false, columnDefinition = "text")
    var input: String = "",

    @Column(nullable = false, columnDefinition = "text")
    var output: String = "",

    @Column(nullable = false, columnDefinition = "text")
    var note: String = "",

    @Column(nullable = false, columnDefinition = "decimal(7, 5)")
    var timeLimit: Double = 1.0,

    @Column(nullable = false)
    var memoryLimit: Int = 256,

    @Column(nullable = false)
    val submitCount: Int = 0,

    @Column(nullable = false)
    val acceptCount: Int = 0
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Problem

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
