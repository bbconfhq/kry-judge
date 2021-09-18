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
//    @GetMapping("/permgroup")
//    fun getUserPrivate(): APIResponse<PermgroupDTO> {
//
//        return
//    }
}