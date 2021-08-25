package org.oooc.kry.problem.entity

import java.io.Serializable
import javax.persistence.*

@Entity
class TestCase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    val problem: Problem = Problem(),

    @Column(nullable = false, columnDefinition = "text")
    val input: String = "",

    @Column(nullable = false, columnDefinition = "text")
    val output: String = ""
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TestCase

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
