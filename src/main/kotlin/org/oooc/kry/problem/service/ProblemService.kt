package org.oooc.kry.problem.service

import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.repository.ProblemRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProblemService(
    private val problemRepository: ProblemRepository
) {
    fun getProblemList(pageable: Pageable): List<Problem> {
        return problemRepository.findAll(pageable).content
    }
}
