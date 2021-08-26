package org.oooc.kry.user

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.oooc.kry.user.domain.dto.UserAddDTO
import org.oooc.kry.user.domain.dto.UserDeleteDTO
import org.oooc.kry.user.web.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserTest {
    @Autowired
    private lateinit var userService: UserService

    @Test
    fun addUser() {
        val seq = "06"

        val payload = UserAddDTO(
            name="user$seq",
            pw="1234",
            nick="nick_name$seq",
            bio="Hello world!",
            email= "user$seq@email.com"
        )

        val user = userService.addUser(payload)

        assertThat(user.nick).isEqualTo(payload.nick)
        assertThat(user.bio).isEqualTo(payload.bio)
        assertThat(user.email).isEqualTo(payload.email)
    }

    @Test
    fun getUserPublic() {
        var seq = "01"
        val payload = "user$seq"
        val user = userService.getUserPublic(payload)

        assertThat(user?.nick).isEqualTo(payload)
        assertThat(user?.bio).isEqualTo(payload)
        assertThat(user?.email).isEqualTo(payload)
    }

    @Test
    fun delete() {
        var seq = "01"
        val payload = UserDeleteDTO(
            name =    "user$seq",
            pw = "1234"
        )

        val result = userService.deleteUser(payload)

        assertThat(result.success).isEqualTo(true)
    }
}