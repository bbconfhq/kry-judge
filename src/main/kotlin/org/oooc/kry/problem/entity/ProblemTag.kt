package org.oooc.kry.problem.entity

import java.io.Serializable
import javax.persistence.*

class ProblemTagId(
    val problem: Problem = Problem(),
    val tag: Tag = Tag()
) : Serializable {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ProblemTagId

        if (problem != other.problem) return false
        if (tag != other.tag) return false

        return true
    }

    override fun hashCode(): Int {
        var result = problem.hashCode()
        result = 31 * result + tag.hashCode()
        return result
    }
}

@Entity
@IdClass(ProblemTagId::class)
class ProblemTag(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    val problem: Problem = Problem(),

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    val tag: Tag = Tag()
) : Serializable
