package org.oooc.kry.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.oooc.kry.user.domain.dto.UserDto
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.web.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    fun createUser() {
        val seq = "06"

        val user = User(
            name="user$seq",
            pw="1234",
            nick="nick_name$seq",
            bio="Hello world!",
            email= "user$seq@email.com"
        )

        userService.addUser(user)
    }

    @Test
    fun getUserByName() {
        var seq = "01"
        val payload = "user$seq"
        val user = userService.getUserByName(payload)
        assertThat(user?.name).isEqualTo(payload)
    }

    @Test
    fun delete() {
        var seq = "01"
        val payload = "user$seq"

        userService.deleteUser(payload)

        val user = userService.getUserByName(payload)
        assertThat(user).isNull()
    }
}