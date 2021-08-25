package org.oooc.kry.problem.repository

import org.oooc.kry.problem.entity.Problem
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProblemRepository : JpaRepository<Problem, Long> {
    fun findByTitle(title: String): Problem?
}
