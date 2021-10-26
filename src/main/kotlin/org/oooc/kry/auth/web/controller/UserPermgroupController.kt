package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.UserPermgroupDTO
import org.oooc.kry.auth.domain.dto.UserPermgroupDeleteDTO
import org.oooc.kry.auth.web.service.UserPermgroupService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class UserPermgroupController(
    private val userPermgroupService: UserPermgroupService
) {
    @PostMapping("/permgroups/{permgroup_id}/users/{user_id}/")
    fun addUsertoPermgroup(
        @PathVariable(name = "permgroup_id") permgroupId: Long,
        @PathVariable(name = "user_id") userId: Long
    ): APIResponse<UserPermgroupDTO> {
        return APIResponse(
            data = userPermgroupService.addUserToPermgroup(permgroupId, userId)
        )
    }

    @DeleteMapping("/permgroups/{permgroup_id}/users/{user_id}/")
    fun deleteUserFromPermgroup(
        @PathVariable(name = "permgroup_id") permgroupId: Long,
        @PathVariable(name = "user_id") userId: Long
    ): APIResponse<CheckDTO> {
        return APIResponse(
            data = userPermgroupService.deleteUserFromPermgroup(permgroupId, userId)
        )
    }
}