package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.*
import org.oooc.kry.auth.web.service.AdminService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/admin")
class AdminController (
    private val adminService: AdminService
) {
    @GetMapping("/permgroups")
    fun getPermgroupList(): APIResponse<List<PermgroupDTO>> {
        return APIResponse(
            data = adminService.getPermgroupList()
        )
    }

    @GetMapping("/permgroups/{permgroup_id}/permissions")
    fun getPermissionsOfPermgroup(@PathVariable(name = "permgroup_id") permgroupId: Long): APIResponse<List<PermissionDTO>> {
        return APIResponse(
            data = adminService.getPermissionsOfPermgroup(permgroupId)
        )
    }

    @PostMapping("/permgroups")
    fun addPermgroup(@RequestBody permgroupAddDTO: PermgroupAddDTO): APIResponse<PermgroupDTO> {
        return APIResponse(
            data = adminService.addPermgroup(permgroupAddDTO)
        )
    }

    @PostMapping("/permgroups/permissions")
    fun addPermissionToPermgroup(@RequestBody permgroupPermissionAddDTO: PermgroupPermissionAddDTO): APIResponse<PermgroupPermissionDTO> {
        return APIResponse(
            data = adminService.addPermissionToPermgroup(permgroupPermissionAddDTO)
        )
    }

    @DeleteMapping("/permgroups/{permgroup_id}")
    fun deletePermgroup(@PathVariable(name = "permgroup_id") permgroupId: Long): APIResponse<CheckDTO> {
        return APIResponse(
            data = adminService.deletePermgroup(permgroupId)
        )
    }

    @GetMapping("/permissions")
    fun getPermissionlist(): APIResponse<List<PermissionDTO>> {
        return APIResponse(
            data = adminService.getPermissionList()
        )
    }

    @PostMapping("/permissions")
    fun addPermission(@RequestBody permissionAddDTO: PermissionAddDTO): APIResponse<PermissionDTO> {
        return APIResponse(
            data = adminService.addPermission(permissionAddDTO)
        )
    }
}