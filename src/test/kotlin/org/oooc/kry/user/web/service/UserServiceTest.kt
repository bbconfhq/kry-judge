package org.oooc.kry.user.web.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.oooc.kry.user.domain.dto.*
import org.oooc.kry.user.web.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.*

@SpringBootTest
class UserServiceTest {
    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var passwordEncoder: PasswordEncoder

    var randomStr = UUID.randomUUID().toString().substring(0, 8)

    @Test
    fun addUser() {

        while (userRepository.existsByName("junit$randomStr"))
            randomStr = UUID.randomUUID().toString().substring(0, 8)

        val payload = UserAddDTO(
            name = "junit$randomStr",
            pw = randomStr,
            nick = "junit$randomStr",
            bio = "unit test add success",
            email = "$randomStr@email.com"
        )

        val user = userService.addUser(payload)

        assertThat(user.nick).isEqualTo(payload.nick)
        assertThat(user.bio).isEqualTo(payload.bio)
        assertThat(user.email).isEqualTo(payload.email)
    }

    @Test
    fun getUserPublic() {
        val payload = "junit$randomStr"
        val user = userService.getUserPublic(payload)

        assertThat(user.nick).isEqualTo(payload)
        assertThat(user.bio).isEqualTo(payload)
        assertThat(user.email).isEqualTo(payload)
    }

    @Test
    fun delete() {
        val payload = UserDeleteDTO(
            name = "junit$randomStr",
            pw = "1234"
        )

        val result = userService.deleteUser(payload)

        assertThat(result.success).isEqualTo(true)
    }

    @Test
    fun encoder() {
        val plainText = "12345678"
        val digest: String = passwordEncoder.encode(plainText)

        print(digest)
        assertTrue(passwordEncoder.matches(plainText, digest))
    }
}