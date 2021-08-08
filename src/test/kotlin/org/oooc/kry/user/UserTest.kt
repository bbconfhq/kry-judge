package org.oooc.kry.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.web.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

@SpringBootTest
class UserTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    fun saveUser() {
        val user = User(name="user01", pw="1234", nick="nick_name01", bio="Hello world!", )
        userService.saveUser(user)
    }

//    @Test
    fun getUserById() {
        val user = userService.getUserById(123)
        assertThat(user.orElse(User(name="no user found")).id).isEqualTo(123)
    }
}