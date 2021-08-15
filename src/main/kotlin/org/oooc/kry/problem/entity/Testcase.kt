package org.oooc.kry.problem.entity

import java.io.Serializable
import javax.persistence.*

@Entity
class Testcase(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false, name = "is_example")
    val example: Boolean = false,

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

        other as Testcase

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}
