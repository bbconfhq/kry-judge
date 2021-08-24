package org.oooc.kry.problem.service

import org.oooc.kry.problem.dto.ProblemAddDTO
import org.oooc.kry.problem.dto.ProblemDTO
import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.exception.ProblemNotFoundException
import org.oooc.kry.problem.repository.ProblemRepository
import org.oooc.kry.problem.repository.ProblemTagRepository
import org.oooc.kry.problem.repository.TestcaseRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class ProblemService(
    private val problemRepository: ProblemRepository,
    private val problemTagRepository: ProblemTagRepository,
    private val testcaseRepository: TestcaseRepository
) {
    fun getProblemList(pageable: Pageable): List<ProblemDTO> {
        val problems = problemRepository.findAll(pageable).content
        val problemDTOs = problems.map { problem ->
            val testcases = testcaseRepository.findAllByProblemAndExampleIsTrue(problem)
            val tags = problemTagRepository.findAllByProblem(problem).map { it.tag }
            ProblemDTO.of(problem, testcases, tags)
        }

        return problemDTOs
    }

    fun getProblem(problemId: Long): ProblemDTO {
        val problem = problemRepository.findByIdOrNull(problemId) ?: throw ProblemNotFoundException()
        val testcases = testcaseRepository.findAllByProblemAndExampleIsTrue(problem)
        val tags = problemTagRepository.findAllByProblem(problem).map { it.tag }

        return ProblemDTO.of(problem, testcases, tags)
    }

    fun getProblem(title: String): ProblemDTO {
        val problem = problemRepository.findByTitle(title) ?: throw ProblemNotFoundException()
        val testcases = testcaseRepository.findAllByProblemAndExampleIsTrue(problem)
        val tags = problemTagRepository.findAllByProblem(problem).map { it.tag }

        return ProblemDTO.of(problem, testcases, tags)
    }

    fun addProblem(problemAddDTO: ProblemAddDTO): ProblemDTO {
        val problem = Problem(
            testcases = problemAddDTO.testcases,
            title = problemAddDTO.title,
            content = problemAddDTO.content,
            input = problemAddDTO.input,
            output = problemAddDTO.output,
            note = problemAddDTO.note,
            timeLimit = problemAddDTO.timeLimit,
            memoryLimit = problemAddDTO.memoryLimit
        )

        return ProblemDTO.of(
            problem = problemRepository.save(problem),
            testcases = problemAddDTO.testcases,
            tags = problemAddDTO.tags
        )
    }
}
