package org.oooc.kry.problem.service

import org.oooc.kry.global.dto.CheckDTO
import org.oooc.kry.problem.dto.ProblemDTO
import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.repository.ProblemRepository
import org.oooc.kry.problem.repository.ProblemTagRepository
import org.oooc.kry.problem.repository.TestcaseRepository
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
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
        val problem = problemRepository.findById(problemId).get()
        val testcases = testcaseRepository.findAllByProblemAndExampleIsTrue(problem)
        val tags = problemTagRepository.findAllByProblem(problem).map { it.tag }

        return ProblemDTO.of(problem, testcases, tags)
    }

    fun addProblem(problemDTO: ProblemDTO): ProblemDTO {
        val problem = Problem(
            testcases = problemDTO.testcases,
            title = problemDTO.title,
            content = problemDTO.content,
            created = problemDTO.created,
            modified = problemDTO.modified,
            input = problemDTO.input,
            output = problemDTO.output,
            note = problemDTO.note,
            timeLimit = problemDTO.timeLimit,
            memoryLimit = problemDTO.memoryLimit
        )

        problemRepository.save(problem)

        return problemDTO
    }
}
