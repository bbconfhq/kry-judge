package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.PermissionAddDTO
import org.oooc.kry.auth.domain.dto.PermissionDTO
import org.oooc.kry.auth.web.service.PermissionService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class PermissionController(
    private val permissionService: PermissionService
) {
    @GetMapping("/permissions")
    fun getPermissionlist(): APIResponse<List<PermissionDTO>> {
        return APIResponse(
            data = permissionService.getPermissionList()
        )
    }

    @PostMapping("/permissions")
    fun addPermission(@RequestBody permissionAddDTO: PermissionAddDTO): APIResponse<PermissionDTO> {
        return APIResponse(
            data = permissionService.addPermission(permissionAddDTO)
        )
    }

    @DeleteMapping("/permissions/{permission_id}")
    fun deletePermission(@PathVariable(name = "permission_id") permissionId: Long): APIResponse<CheckDTO> {
        return APIResponse(
            data = permissionService.deletePermission(permissionId)
        )
    }
}