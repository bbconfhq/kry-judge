package org.oooc.kry.user.web

import org.oooc.kry.user.domain.entity.User
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    @PostMapping("")
    fun createUser(@RequestParam user: User): User =
        userService.createUser(user)

    @GetMapping("/{nick}")
    fun getUserByName(@PathVariable("nick") name: String) =
        userService.getUser(name)

    @PutMapping("")
    fun updateUser(@RequestParam user: User) =
        userService.updateUser(user)

    @DeleteMapping("")
    fun deleteUser(@RequestParam name: String) =
        userService.deleteUser(name)
}