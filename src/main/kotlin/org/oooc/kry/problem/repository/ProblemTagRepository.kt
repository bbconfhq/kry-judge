package org.oooc.kry.problem.repository

import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.entity.ProblemTag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProblemTagRepository : JpaRepository<ProblemTag, Long> {
    fun findAllByProblem(problem: Problem): List<ProblemTag>
}
