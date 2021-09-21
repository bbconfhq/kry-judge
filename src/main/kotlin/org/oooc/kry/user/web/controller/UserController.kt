package org.oooc.kry.user.web.controller

import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.user.domain.dto.*
import org.oooc.kry.user.web.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/users")
class UserController(private val userService: UserService) {

    // 공개된 정보는 닉네임을 통해 조회. username은 로그인 할 때만 사용합니다.
    @GetMapping("/{nick}")
    fun getUserPublic(@PathVariable("nick") nick: String): APIResponse<UserPublicDTO>{
        return APIResponse(
            data = userService.getUserPublic(nick)
        )
    }

    @GetMapping("")
    fun getUserPrivate(): APIResponse<UserPrivateDTO> {
        /**
         * TODO(Jerry) 세션에서 유저 이름 가져오기
         */
        val name = ""
        return APIResponse(
            data = userService.getUserPrivate(name)
        )
    }

    @PostMapping("")
    fun addUser(@RequestBody userAddDTO: UserAddDTO): APIResponse<UserPrivateDTO> {
        return APIResponse(
            data = userService.addUser(userAddDTO)
        )
    }

    @PutMapping("")
    fun updateUser(@RequestBody userUpdateDTO: UserUpdateDTO): APIResponse<UserPrivateDTO> {
        return APIResponse(
            data = userService.updateUser(userUpdateDTO)
        )
    }

    @DeleteMapping("")
    fun deleteUser(@RequestBody userDeleteDTO: UserDeleteDTO) =
        userService.deleteUser(userDeleteDTO)

}