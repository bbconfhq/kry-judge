package org.oooc.kry.user.web.controller

import org.oooc.kry.user.domain.dto.UserDto
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.web.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    @PostMapping("")
    fun createUser(@RequestBody userDto: UserDto): User {
        val user = User(
            name = userDto.name,
            pw = userDto.pw,
            nick = userDto.nick,
            email = userDto.email,
            bio = userDto.bio
        )

        return userService.createUser(user)
    }

    @GetMapping("/{nick}")
    fun getUserByNick(@PathVariable("nick") nick: String) =
        userService.getUserByNick(nick)

    @PutMapping("")
    fun updateUser(@RequestBody user: User) =
        userService.updateUser(user)

    @DeleteMapping("")
    fun deleteUser(@RequestBody name: String) =
        userService.deleteUser(name)

}