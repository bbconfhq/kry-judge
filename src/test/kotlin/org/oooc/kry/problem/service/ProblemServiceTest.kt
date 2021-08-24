package org.oooc.kry.problem.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.oooc.kry.problem.dto.ProblemDTO
import org.oooc.kry.problem.entity.Problem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class ProblemServiceTest {
    @Autowired
    private lateinit var problemService: ProblemService

    @Test
    fun getProblem() {
        val problem = problemService.getProblem(1000)
        assertThat(problem.title).isEqualTo("A+B")
        assertThat(problem.content).isEqualTo("두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.")
    }

    @Test
    @Transactional
    fun addProblem() {
        val problemAddDto = ProblemAddDTO(
            title = "테스트 문제",
            content = "이 문제는 테스트 문제입니다.",
            input = "3이 입력된다.",
            output = "5를 출력한다."
        )

        problemService.addProblem(problemAddDto)

        val findProblem = problemService.getProblem("테스트 문제")
        assertThat(findProblem.input).isEqualTo("3이 입력된다.")
    }
}
