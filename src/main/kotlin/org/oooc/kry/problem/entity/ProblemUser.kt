package org.oooc.kry.problem.entity

import java.io.Serializable
import javax.persistence.*

/**
 * TODO
 * - add User field
 * - override equals, hashCode method
 */
class ProblemUserId(
    val problem: Problem = Problem()
) : Serializable

@Entity
@IdClass(ProblemUserId::class)
class ProblemUser(
    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id")
    val problem: Problem = Problem(),

    /**
     * TODO: Add User field
     * val user: User
     */
) : Serializable
