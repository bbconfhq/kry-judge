package org.oooc.kry.problem.service

import org.oooc.kry.problem.dto.ProblemDTO
import org.oooc.kry.problem.repository.ProblemRepository
import org.oooc.kry.problem.repository.ProblemTagRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class ProblemService(
    private val problemRepository: ProblemRepository,
    private val problemTagRepository: ProblemTagRepository
) {
    fun getProblemList(pageable: Pageable): List<ProblemDTO> {
        val problems = problemRepository.findAll(pageable).content
        val problemDTOs = problems.map { problem ->
            val tags = problemTagRepository.findAllByProblem(problem).map { it.tag }
            ProblemDTO.of(problem, tags)
        }

        return problemDTOs
    }
}
