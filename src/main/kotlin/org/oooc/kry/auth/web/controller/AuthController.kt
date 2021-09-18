package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.*
import org.oooc.kry.auth.web.service.AuthService
import org.oooc.kry.global.dto.APIResponse
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/auth")
class AuthController (
    private val authService: AuthService
) {
    @GetMapping("/permgroup/list")
    fun getPermgroupList(): APIResponse<List<PermgroupDTO>> {
        return APIResponse(
            data = authService.getPermgroupList()
        )
    }

    @PostMapping("/permgroup")
    fun addPermgroup(@RequestParam name: String): APIResponse<PermgroupDTO> {
        return APIResponse(
            data = authService.addPermgroup(name)
        )
    }

    @PostMapping("/permgroup/permission")
    fun addPermissionToPermgroup(@RequestBody permgroupPermissionAddDTO: PermgroupPermissionAddDTO): APIResponse<PermgroupPermissionDTO> {
        return APIResponse(
            data = authService.addPermissionToPermgroup(permgroupPermissionAddDTO)
        )
    }
}