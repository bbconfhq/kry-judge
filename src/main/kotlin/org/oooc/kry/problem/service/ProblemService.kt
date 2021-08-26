package org.oooc.kry.problem.service

import org.oooc.kry.global.dto.CheckDTO
import org.oooc.kry.problem.dto.ProblemAddDTO
import org.oooc.kry.problem.dto.ProblemDTO
import org.oooc.kry.problem.dto.ProblemUpdateDTO
import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.exception.ProblemNotFoundException
import org.oooc.kry.problem.repository.ProblemRepository
import org.oooc.kry.problem.repository.ProblemTagRepository
import org.oooc.kry.problem.repository.TestcaseRepository
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.OffsetDateTime
import java.time.ZoneOffset

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
            val testcases = testcaseRepository.findAllByProblemAndVisibleIsTrue(problem)
            val tags = problemTagRepository.findAllByProblem(problem).map { it.tag }
            ProblemDTO.of(problem, testcases, tags)
        }

        return problemDTOs
    }

    fun getProblem(problemId: Long): ProblemDTO {
        val problem = problemRepository.findByIdOrNull(problemId) ?: throw ProblemNotFoundException()
        val testcases = testcaseRepository.findAllByProblemAndVisibleIsTrue(problem)
        val tags = problemTagRepository.findAllByProblem(problem).map { it.tag }

        return ProblemDTO.of(problem, testcases, tags)
    }

    fun getProblem(title: String): ProblemDTO {
        val problem = problemRepository.findByTitle(title) ?: throw ProblemNotFoundException()
        val testcases = testcaseRepository.findAllByProblemAndVisibleIsTrue(problem)
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

    fun updateProblem(problemId: Long, problemUpdateDTO: ProblemUpdateDTO): ProblemDTO {
        val problem = problemRepository.findByIdOrNull(problemId) ?: throw ProblemNotFoundException()
        val updatedProblem = problem.apply {
            title = problemUpdateDTO.title
            content = problemUpdateDTO.content
            modified = OffsetDateTime.now(ZoneOffset.of("+00:00"))
            input = problemUpdateDTO.input
            output = problemUpdateDTO.output
            note = problemUpdateDTO.note
            timeLimit = problemUpdateDTO.timeLimit
            memoryLimit = problemUpdateDTO.memoryLimit
            testcases = problemUpdateDTO.testcases
        }

        val tags = problemTagRepository.findAllByProblem(problem).map { it.tag }
        val testcases = testcaseRepository.findAllByProblem(problem)

        return ProblemDTO.of(
            problem = updatedProblem,
            testcases = testcases,
            tags = tags
        )
    }

    fun deleteProblem(problemId: Long): CheckDTO {
        val problem = problemRepository.findByIdOrNull(problemId) ?: throw ProblemNotFoundException()
        problemRepository.delete(problem)

        return CheckDTO(true)
    }
}
