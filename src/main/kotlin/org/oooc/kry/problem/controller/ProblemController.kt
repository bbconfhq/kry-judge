package org.oooc.kry.problem.controller

import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.problem.dto.ProblemAddDTO
import org.oooc.kry.problem.dto.ProblemDTO
import org.oooc.kry.problem.dto.ProblemUpdateDTO
import org.oooc.kry.problem.service.ProblemService
import org.springframework.web.bind.annotation.*

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
            data = problemService.getProblem(problemId)
        )
    }

    @PostMapping("")
    fun addProblem(
        @RequestBody problemAddDTO: ProblemAddDTO
    ): APIResponse<ProblemDTO> {
        return APIResponse(
            data = problemService.addProblem(problemAddDTO)
        )
    }

    @PutMapping("/{problem_id}")
    fun updateProblem(
        @PathVariable(name = "problem_id") problemId: Long,
        @RequestBody problemUpdateDTO: ProblemUpdateDTO
    ): APIResponse<ProblemDTO> {
        return APIResponse(
            data = problemService.updateProblem(problemId, problemUpdateDTO)
        )
    }
}
