package org.oooc.kry.problem.controller

import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.problem.dto.TestcaseAddDTO
import org.oooc.kry.problem.dto.TestcaseDTO
import org.oooc.kry.problem.service.TestcaseService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/testcase")
class TestcaseController(
    private val testcaseService: TestcaseService
) {
    @PostMapping("")
    fun addTestcase(
        @RequestBody testcaseAddDTO: TestcaseAddDTO
    ): APIResponse<TestcaseDTO> {
        return APIResponse(
            data = testcaseService.addTestcase(testcaseAddDTO)
        )
    }
}
