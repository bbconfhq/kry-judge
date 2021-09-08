package org.oooc.kry.problem.controller

import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.oooc.kry.problem.dto.TestcaseAddDTO
import org.oooc.kry.problem.dto.TestcaseDTO
import org.oooc.kry.problem.dto.TestcaseUpdateDTO
import org.oooc.kry.problem.service.TestcaseService
import org.springframework.web.bind.annotation.*

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

    @PutMapping("/{testcase_id}")
    fun updateTestcase(
        @PathVariable(name = "testcase_id") testcaseId: Long,
        @RequestBody testcaseUpdateDTO: TestcaseUpdateDTO
    ): APIResponse<TestcaseDTO> {
        return APIResponse(
            data = testcaseService.updateTestcase(testcaseId, testcaseUpdateDTO)
        )
    }

    @DeleteMapping("/{testcase_id}")
    fun deleteTestcase(
        @PathVariable(name = "testcase_id") testcaseId: Long
    ): APIResponse<CheckDTO> {
        return APIResponse(
            data = testcaseService.deleteTestcase(testcaseId)
        )
    }
}
