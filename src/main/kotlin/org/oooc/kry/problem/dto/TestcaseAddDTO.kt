package org.oooc.kry.problem.dto

data class TestcaseAddDTO(
    val problemId: Long = 0,
    val visible: Boolean = false,
    val input: String = "",
    val output: String = ""
)
