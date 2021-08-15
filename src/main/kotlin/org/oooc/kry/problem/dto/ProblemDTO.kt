package org.oooc.kry.problem.dto

import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.entity.Tag
import java.time.OffsetDateTime

data class ProblemDTO(
    val id: Long,
    val title: String,
    val content: String,
    val created: OffsetDateTime,
    val modified: OffsetDateTime,
    val input: String,
    val output: String,
    val note: String,
    val timeLimit: Double,
    val memoryLimit: Int,
    val submitCount: Int,
    val acceptCount: Int,
    val tags: List<Tag>,
) {
    companion object {
        fun of(problem: Problem, tags: List<Tag> = emptyList()) = ProblemDTO(
            id = problem.id,
            title = problem.title,
            content = problem.content,
            created = problem.created,
            modified = problem.modified,
            input = problem.input,
            output = problem.output,
            note = problem.note,
            timeLimit = problem.timeLimit,
            memoryLimit = problem.memoryLimit,
            submitCount = problem.submitCount,
            acceptCount = problem.acceptCount,
            tags = tags
        )
    }
}
