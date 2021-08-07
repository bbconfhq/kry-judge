package org.oooc.kry.problem.controller

import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.service.ProblemService
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/problemset")
class ProblemSetController(
    private val problemService: ProblemService
) {
    companion object {
        const val MAX_PROBLEM_NUMBER_PER_PAGE = 10
    }

    @GetMapping("", "/{page}")
    fun getProblemList(
        @PathVariable(value = "page", required = false) page: Int?,
        @RequestParam(defaultValue = "$MAX_PROBLEM_NUMBER_PER_PAGE") num: Int
    ): List<Problem> {
        if (num > MAX_PROBLEM_NUMBER_PER_PAGE || num < 1) {
            throw IllegalArgumentException("Parameter(num) must be 1 <= num <= $MAX_PROBLEM_NUMBER_PER_PAGE")
        }

        return problemService.getProblemList(PageRequest.of(page ?: 0, num))
    }
}
