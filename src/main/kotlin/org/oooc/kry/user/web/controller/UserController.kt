package org.oooc.kry.user.web.controller

import org.oooc.kry.user.domain.dto.UserDto
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.web.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    @PostMapping("")
    fun createUser(@RequestBody user: UserDto): User =
        userService.createUser(User(user))

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