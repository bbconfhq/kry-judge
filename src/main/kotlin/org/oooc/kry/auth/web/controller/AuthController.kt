package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.*
import org.oooc.kry.auth.web.service.AuthService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class AuthController (
    private val authService: AuthService
) {
    @GetMapping("/permgroups")
    fun getPermgroupList(): APIResponse<List<PermgroupDTO>> {
        return APIResponse(
            data = authService.getPermgroupList()
        )
    }

    @GetMapping("/permgroups/{permgroup_id}/permissions")
    fun getPermissionsOfPermgroup(@PathVariable(name = "permgroup_id") permgroupId: Long): APIResponse<List<PermissionDTO>> {
        return APIResponse(
            data = authService.getPermissionsOfPermgroup(permgroupId)
        )
    }

    @PostMapping("/permgroups")
    fun addPermgroup(@RequestBody permgroupAddDTO: PermgroupAddDTO): APIResponse<PermgroupDTO> {
        return APIResponse(
            data = authService.addPermgroup(permgroupAddDTO)
        )
    }

    @PostMapping("/permgroups/permissions")
    fun addPermissionToPermgroup(@RequestBody permgroupPermissionAddDTO: PermgroupPermissionAddDTO): APIResponse<PermgroupPermissionDTO> {
        return APIResponse(
            data = authService.addPermissionToPermgroup(permgroupPermissionAddDTO)
        )
    }

    @DeleteMapping("/permgroups/{permgroup_id}")
    fun deletePermgroup(@PathVariable(name = "permgroup_id") permgroupId: Long): APIResponse<CheckDTO> {
        return APIResponse(
            data = authService.deletePermgroup(permgroupId)
        )
    }

    @GetMapping("/permissions")
    fun getPermissionlist(): APIResponse<List<PermissionDTO>> {
        return APIResponse(
            data = authService.getPermissionList()
        )
    }

    @PostMapping("/permissions")
    fun addPermission(@RequestBody permissionAddDTO: PermissionAddDTO): APIResponse<PermissionDTO> {
        return APIResponse(
            data = authService.addPermission(permissionAddDTO)
        )
    }
}