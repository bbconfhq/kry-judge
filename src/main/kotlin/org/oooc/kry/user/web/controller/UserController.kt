package org.oooc.kry.user.web.controller

import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.user.domain.dto.UserDto
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.web.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    @PostMapping("")
    fun addUser(@RequestBody userDto: UserDto): APIResponse<User> {
        val user = User(
            name = userDto.name,
            pw = userDto.pw,
            nick = userDto.nick,
            email = userDto.email,
            bio = userDto.bio
        )

        return APIResponse(
            data = userService.addUser(user)
        )
    }

    // 공개된 정보는 닉네임을 통해 조회. username은 로그인 할 때만 사용합니다.
    @GetMapping("/{nick}")
    fun getUserByNick(@PathVariable("nick") nick: String) =
        userService.getUserByNick(nick)

    @GetMapping("/{name}")
    fun getUserByName(@PathVariable("name") name: String) =
        userService.getUserByName(name)

    @PutMapping("")
    fun updateUser(@RequestBody user: User, @RequestBody name: String) =
        userService.updateUser(user)

    @DeleteMapping("")
    fun deleteUser(@RequestBody name: String) =
        userService.deleteUser(name)

}