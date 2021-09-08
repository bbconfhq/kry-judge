package org.oooc.kry.problem.service

import org.oooc.kry.global.dto.CheckDTO
import org.oooc.kry.problem.dto.TestcaseAddDTO
import org.oooc.kry.problem.dto.TestcaseDTO
import org.oooc.kry.problem.dto.TestcaseUpdateDTO
import org.oooc.kry.problem.entity.Testcase
import org.oooc.kry.problem.exception.ProblemNotFoundException
import org.oooc.kry.problem.exception.TestcaseNotFoundException
import org.oooc.kry.problem.repository.ProblemRepository
import org.oooc.kry.problem.repository.TestcaseRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TestcaseService(
    private val testcaseRepository: TestcaseRepository,
    private val problemRepository: ProblemRepository
) {
    fun addTestcase(testcaseAddDTO: TestcaseAddDTO): TestcaseDTO {
        val problem = problemRepository.findByIdOrNull(testcaseAddDTO.problemId) ?: throw ProblemNotFoundException()
        val testcase = Testcase(
            problem = problem,
            visible = testcaseAddDTO.visible,
            input = testcaseAddDTO.input,
            output = testcaseAddDTO.output
        )

        return TestcaseDTO.of(testcaseRepository.save(testcase))
    }

    fun updateTestcase(testcaseId: Long, testcaseUpdateDTO: TestcaseUpdateDTO): TestcaseDTO {
        val testcase = testcaseRepository.findByIdOrNull(testcaseId) ?: throw TestcaseNotFoundException()
        val updatedProblem = problemRepository.findByIdOrNull(testcaseUpdateDTO.problemId) ?: throw ProblemNotFoundException()
        val updatedTestcase = testcase.apply {
            problem = updatedProblem
            visible = testcaseUpdateDTO.visible
            input = testcaseUpdateDTO.input
            output = testcaseUpdateDTO.output
        }

        return TestcaseDTO.of(updatedTestcase)
    }

    fun deleteTestcase(testcaseId: Long): CheckDTO {
        val testcase = testcaseRepository.findByIdOrNull(testcaseId) ?: throw TestcaseNotFoundException()
        testcaseRepository.delete(testcase)

        return CheckDTO(true)
    }
}
