package org.oooc.kry.problem.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.oooc.kry.problem.dto.TestcaseAddDTO
import org.oooc.kry.problem.dto.TestcaseUpdateDTO
import org.oooc.kry.problem.repository.ProblemRepository
import org.oooc.kry.problem.repository.TestcaseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class TestcaseServiceTest {
    @Autowired
    private lateinit var testcaseService: TestcaseService

    @Autowired
    private lateinit var testcaseRepository: TestcaseRepository

    @Autowired
    private lateinit var problemRepository: ProblemRepository

    @Test
    fun addTestcase() {
        val testcaseAddDTO = TestcaseAddDTO(
            problemId = 1000,
            visible = true,
            input = "3 7",
            output = "10"
        )

        testcaseService.addTestcase(testcaseAddDTO)

        val problem = problemRepository.findByIdOrNull(1000)
        val findTestcases = testcaseRepository.findAllByProblemAndVisibleIsTrue(problem!!)

        assertThat(findTestcases.any {
            it.input == "3 7"
        }).isTrue
    }

    @Test
    fun updateTestcase() {
        val testcaseUpdateDTO = TestcaseUpdateDTO(
            problemId = 1000,
            visible = true,
            input = "3 7",
            output = "10"
        )

        testcaseService.updateTestcase(1, testcaseUpdateDTO)

        val problem = problemRepository.findByIdOrNull(1000)
        val findTestcase = testcaseRepository.findAllByProblemAndVisibleIsTrue(problem!!)[0]

        assertThat(findTestcase.input).isEqualTo("3 7")
    }

    @Test
    fun deleteTestcase() {
        val problem = problemRepository.findByIdOrNull(1000)
        val testcases = testcaseRepository.findAllByProblem(problem!!)

        testcaseService.deleteTestcase(1)

        val testcasesAfterDelete = testcaseRepository.findAllByProblem(problem)

        assertThat(testcasesAfterDelete.size).isEqualTo(testcases.size - 1)
    }
}
