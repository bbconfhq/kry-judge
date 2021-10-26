package org.oooc.kry.user.web.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertTrue
import org.oooc.kry.user.domain.dto.UserAddDTO
import org.oooc.kry.user.domain.dto.UserDeleteDTO
import org.oooc.kry.user.domain.dto.UserUpdateDTO
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.domain.exception.UserNotFoundException
import org.oooc.kry.user.web.repository.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.security.crypto.password.PasswordEncoder
import java.util.*
import javax.transaction.Transactional


@Transactional
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
@DisplayName("유저 통합 테스트")
class UserServiceTest {
    @Autowired private lateinit var passwordEncoder: PasswordEncoder
    @Autowired private lateinit var userService: UserService

    val testUser = User(
        name = "e3f90cba",
        pw = "19c39f1a",
        nick = "ef1df98a",
        bio = "unit test sample bio",
        email = "d685cc4c@junit.com"
    )

    fun getUserAddDTO(user: User): UserAddDTO {
       return UserAddDTO(
           name = testUser.name,
           pw = testUser.pw,
           nick = testUser.nick,
           bio = testUser.bio,
           email = testUser.email
       )
    }

    @Test
    @DisplayName("유저 생성")
    fun addUser() {
        val userPrivateDTO= userService.addUser(getUserAddDTO(testUser))

        assertThat(userPrivateDTO.name).isEqualTo(testUser.name)
        assertThat(userPrivateDTO.nick).isEqualTo(testUser.nick)
        assertThat(userPrivateDTO.bio).isEqualTo(testUser.bio)
        assertThat(userPrivateDTO.email).isEqualTo(testUser.email)
    }

    @Test
    @DisplayName("유저 공개 정보 조회")
    fun getUserPublic() {
        userService.addUser(getUserAddDTO(testUser))

        val userPublicDTO = userService.getUserPublic(testUser.nick)

        assertThat(userPublicDTO.bio).isEqualTo(testUser.bio)
        assertThat(userPublicDTO.email).isEqualTo(testUser.email)
        assertThat(userPublicDTO.nick).isEqualTo(testUser.nick)
    }

    @Test
    @DisplayName("유저 개인 정보 조회")
    fun getUserPrivate() {
        userService.addUser(getUserAddDTO(testUser))

        val user = userService.getUserPrivate(testUser.name)

        assertThat(user.name).isEqualTo(testUser.name)
        assertThat(user.nick).isEqualTo(testUser.nick)
        assertThat(user.bio).isEqualTo(testUser.bio)
        assertThat(user.email).isEqualTo(testUser.email)
    }

    @Test
    @DisplayName("유저 수정")
    fun updateUser() {
        userService.addUser(getUserAddDTO(testUser))

        val userUpdateDTO = UserUpdateDTO(
            name = testUser.name,
            pw = testUser.pw,
            nick = "3d77ac3f",
            bio = "update test bio",
            email = testUser.email
        )

        val newUser = userService.updateUser(userUpdateDTO)
        assertThat(newUser.nick).isEqualTo(userUpdateDTO.nick)
        assertThat(newUser.bio).isEqualTo(userUpdateDTO.bio)
    }

    @Test
    @DisplayName("유저 삭제")
    fun delete() {
        userService.addUser(getUserAddDTO(testUser))

        val userDeleteDTO= UserDeleteDTO(
            name = testUser.name,
            pw = testUser.pw
        )

        val result = userService.deleteUser(userDeleteDTO)

        assertThat(result.success).isEqualTo(true)
    }

    @Test
    @DisplayName("비밀번호 암호화")
    fun encoder() {
        val plainText = "12345678"
        val digest: String = passwordEncoder.encode(plainText)

        print(digest)
        assertTrue(passwordEncoder.matches(plainText, digest))
    }
}