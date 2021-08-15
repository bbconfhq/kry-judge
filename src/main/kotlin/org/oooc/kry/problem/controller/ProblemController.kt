package org.oooc.kry.problem.controller

import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.problem.dto.ProblemDTO
import org.oooc.kry.problem.service.ProblemService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/problem")
class ProblemController(
    private val problemService: ProblemService
) {
    @GetMapping("/{problem_id}")
    fun getProblem(
        @PathVariable(name = "problem_id") problemId: Long
    ): APIResponse<ProblemDTO> {
        return APIResponse(
            result = problemService.getProblem(problemId)
        )
    }


}
