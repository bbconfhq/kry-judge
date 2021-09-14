package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.PermgroupPostRequestDTO
import org.oooc.kry.auth.domain.dto.PermgroupPostResponseDTO
import org.oooc.kry.auth.domain.dto.PermgroupGetResponseDTO
import org.oooc.kry.auth.domain.dto.PermissionGetResponseDTO
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
    fun getPermgroupList(): APIResponse<List<PermgroupGetResponseDTO>> {
        return APIResponse(authService.getPermgroupList())
    }
    @GetMapping("permission/list")
    fun getPermissionList(): APIResponse<List<PermissionGetResponseDTO>> {
        return APIResponse(authService.getPermissionList())
    }
    @PostMapping("/permgroup")
    fun addPermgroup(@RequestBody @Valid permgroupPostRequestDTO: PermgroupPostRequestDTO): APIResponse<PermgroupPostResponseDTO> {
        return APIResponse(authService.addPermgroup(permgroupPostRequestDTO))
    }
}