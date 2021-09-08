package org.oooc.kry.problem.dto

data class TestcaseUpdateDTO(
    val problemId: Long = 0,
    val visible: Boolean = false,
    val input: String = "",
    val output: String = ""
)
