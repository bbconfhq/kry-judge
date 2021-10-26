package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.PermgroupPermissionAddDTO
import org.oooc.kry.auth.domain.dto.PermgroupPermissionDTO
import org.oooc.kry.auth.web.service.PermgroupPermissionService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class PermgroupPermissionController(
    private val permgroupPermissionService: PermgroupPermissionService
) {
    @PostMapping("/permgroups/{permgroup_id}/permissions/{permission_id}")
    fun addPermissionToPermgroup(
        @PathVariable(name = "permgroup_id") permgroupId: Long,
        @PathVariable(name = "permission_id") permissionId: Long
    ): APIResponse<PermgroupPermissionDTO> {
        return APIResponse(
            data = permgroupPermissionService.addPermissionToPermgroup(permgroupId, permissionId)
        )
    }

    @DeleteMapping("/permgroups/{permgroup_id}/permissions/{permission_id}")
    fun deletePermissionFromPermgroup(
        @PathVariable(name = "permgroup_id") permgroupId: Long,
        @PathVariable(name = "permission_id") permissionId: Long
    ): APIResponse<CheckDTO> {
        return APIResponse(
            data = permgroupPermissionService.deletePermissionFromPermgroup(permgroupId, permissionId)
        )
    }
}