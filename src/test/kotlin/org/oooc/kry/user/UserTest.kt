package org.oooc.kry.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.web.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    fun saveUser() {
        val seq = "05"
        val user = User(name="user$seq", pw="1234", nick="nick_name$seq", bio="Hello world!", email= "user$seq@email.com")
        userService.createUser(user)
    }

    @Test
    fun getUserById() {
        val user = userService.getUser("user01")
        assertThat(user?.id).isEqualTo(1)
    }

    @Test
    fun delete() {
        userService.deleteUser("user01")
        val user = userService.getUser("user01")
        assertThat(user).isNull()
    }
}