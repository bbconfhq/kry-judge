package org.oooc.kry.problem.dto

import org.oooc.kry.problem.entity.Tag
import org.oooc.kry.problem.entity.Testcase

data class ProblemAddDTO(
    val title: String = "",
    val content: String = "",
    val input: String = "",
    val output: String = "",
    val note: String = "",
    val timeLimit: Double = 1.0,
    val memoryLimit: Int = 128,
    val testcases: List<Testcase> = emptyList(),
    val tags: List<Tag> = emptyList()
)
