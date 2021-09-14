package org.oooc.kry.auth.web.controller

import org.oooc.kry.auth.domain.dto.PermgroupDto
import org.oooc.kry.auth.web.service.AuthService
import org.oooc.kry.global.dto.APIResponse
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController (
    private val authService: AuthService
) {
    @GetMapping("/permgroup/list")
    fun getPermgroupList(): APIResponse<List<PermgroupDto>> {
        return APIResponse(authService.getPermgroupList())
    }
}