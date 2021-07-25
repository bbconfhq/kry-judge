package org.oooc.kry.problem.controller

import org.oooc.kry.problem.entity.Problem
import org.oooc.kry.problem.service.ProblemService
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/problemset")
class ProblemSetController(
    private val problemService: ProblemService
) {
    val PROBLEM_NUMBER_PER_PAGE = 10

    @GetMapping("", "/{page}")
    fun getProblemList(@PathVariable(value = "page", required = false) page: Int?): List<Problem> {
        return problemService.getProblemList(PageRequest.of(page ?: 0, PROBLEM_NUMBER_PER_PAGE))
    }
}
