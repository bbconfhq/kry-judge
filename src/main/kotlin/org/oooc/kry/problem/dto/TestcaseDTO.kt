package org.oooc.kry.problem.dto

import org.oooc.kry.problem.entity.Testcase

data class TestcaseDTO(
    val id: Long = 0,
    val problemId: Long,
    val visible: Boolean = false,
    val input: String = "",
    val output: String = ""
) {
    companion object {
        fun of(testcase: Testcase) = TestcaseDTO(
            id = testcase.id,
            problemId = testcase.problem.id,
            visible = testcase.visible,
            input = testcase.input,
            output = testcase.output
        )
    }
}
