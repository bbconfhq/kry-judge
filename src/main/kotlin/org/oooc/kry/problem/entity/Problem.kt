package org.oooc.kry.problem.entity

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
    val testcases: List<TestCase> = emptyList(),

    @Column(nullable = false, unique = true, length = 191)
    val title: String = "",

    @Column(nullable = false, columnDefinition = "text")
    val content: String = "",

    @Column(nullable = false)
    val created: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+09:00")),

    @Column(nullable = false)
    val modified: OffsetDateTime = OffsetDateTime.now(ZoneOffset.of("+09:00")),

    @Column(nullable = false, columnDefinition = "text")
    val input: String = "",

    @Column(nullable = false, columnDefinition = "text")
    val output: String = "",

    @Column(nullable = false, columnDefinition = "text")
    val note: String = "",

    @Column(nullable = false, columnDefinition = "decimal(7, 5)")
    val timeLimit: Double = 1.0,

    @Column(nullable = false)
    val memoryLimit: Int = 256,

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
