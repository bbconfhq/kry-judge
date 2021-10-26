package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.PermgroupAddDTO
import org.oooc.kry.auth.domain.dto.PermgroupDTO
import org.oooc.kry.auth.domain.dto.PermissionDTO
import org.oooc.kry.auth.web.service.PermgroupService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/auth")
class PermgroupController(
    private val permgroupService: PermgroupService
) {
    @GetMapping("/permgroups")
    fun getPermgroupList(): APIResponse<List<PermgroupDTO>> {
        return APIResponse(
            data = permgroupService.getPermgroupList()
        )
    }

    @GetMapping("/permgroups/{permgroup_id}/permissions")
    fun getPermissionsOfPermgroup(@PathVariable(name = "permgroup_id") permgroupId: Long): APIResponse<List<PermissionDTO>> {
        return APIResponse(
            data = permgroupService.getPermissionsOfPermgroup(permgroupId)
        )
    }

    @PostMapping("/permgroups")
    fun addPermgroup(@RequestBody permgroupAddDTO: PermgroupAddDTO): APIResponse<PermgroupDTO> {
        return APIResponse(
            data = permgroupService.addPermgroup(permgroupAddDTO)
        )
    }

    @DeleteMapping("/permgroups/{permgroup_id}")
    fun deletePermgroup(@PathVariable(name = "permgroup_id") permgroupId: Long): APIResponse<CheckDTO> {
        return APIResponse(
            data = permgroupService.deletePermgroup(permgroupId)
        )
    }
}