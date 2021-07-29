package org.oooc.kry.user.web

import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.domain.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/user")
class UserController(private val userService: UserService) {
    @GetMapping("/employees/{id}")
    fun getEmployeesById(@PathVariable("id") userId: Long): User =
        userService.getUserById(userId)

    @PostMapping("/employees")
    fun createUser(@RequestBody payload: User): User = userService.createUser(payload)
}