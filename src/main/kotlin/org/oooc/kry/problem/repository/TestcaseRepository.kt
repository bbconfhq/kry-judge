package org.oooc.kry.problem.repository

import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.entity.Testcase
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TestcaseRepository : JpaRepository<Testcase, Long> {
    fun findAllByProblemAndVisibleIsTrue(problem: Problem): List<Testcase>

    fun findAllByProblem(problem: Problem): List<Testcase>
}
