package org.oooc.kry.user

import org.junit.jupiter.api.Test
import org.oooc.kry.user.web.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class userTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    fun getUserById() {
        val user = userService.getUserById(123)
        println(user)
    }
}