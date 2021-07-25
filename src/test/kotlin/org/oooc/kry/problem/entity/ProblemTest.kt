package org.oooc.kry.problem.entity

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.oooc.kry.problem.repository.ProblemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProblemTest {
    @Autowired
    private lateinit var problemRepository: ProblemRepository

    @Test
    fun getProblemByTitle() {
        val problem = problemRepository.findByTitle("A+B")
        assertThat(problem?.title).isEqualTo("A+B")
    }
}
