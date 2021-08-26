package org.oooc.kry.user.web.service

import org.oooc.kry.global.dto.CheckDTO
import org.oooc.kry.user.domain.dto.*
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.domain.repository.UserRepository
import org.oooc.kry.user.web.exception.UserNotFoundException
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun findAll(sort: Sort) = userRepository.findAll(sort)

    fun getUserPublic(nick: String): UserPublicDTO {
        val user = userRepository.findByNick(nick) ?: throw UserNotFoundException()
        return UserPublicDTO(
            user.nick,
            user.email,
            user.bio
        )
    }

    fun getUserPrivate(): UserPrivateDTO {
        val user = User()

        /** TODO(Jerry): 2021-08-26 Session check
         * 유저 개인정보는 세션에서 가져올 것
         */

        return  UserPrivateDTO(
            user.name,
            user.nick,
            user.email,
            user.bio
        )
    }

    fun addUser(userAddDTO: UserAddDTO): UserPublicDTO {
        val user = userRepository.save(
            User(
                name = userAddDTO.name,
                /** TODO(Jerry): 2021-08-26 hashing password
                 * DB에 저장될 password는 메시지 다이제스트
                 */
                pw = userAddDTO.pw,
                nick = userAddDTO.nick,
                email = userAddDTO.email,
                bio = userAddDTO.bio
            )
        )

        return UserPublicDTO(
            user.nick,
            user.email,
            user.bio
        )
    }

    fun updateUser(userUpdateDTO: UserUpdateDTO): UserPrivateDTO {
        var newUser = userRepository.findByName(userUpdateDTO.name) ?: throw UserNotFoundException()

        /** TODO(Jerry): 2021-08-26 Session check
         * 세션의 유저와 업데이트할 유저가 동일한지 확인
         */

        newUser.apply {
            pw = userUpdateDTO.pw
            nick = userUpdateDTO.nick
            bio = userUpdateDTO.bio
        }

        return UserPrivateDTO(
            newUser.name,
            newUser.nick,
            newUser.email,
            newUser.bio
        )
    }

    fun deleteUser(userDeleteDTO: UserDeleteDTO): CheckDTO{
        val user = userRepository.findByName(userDeleteDTO.name) ?: throw UserNotFoundException()

        /** TODO(Jerry): 2021-08-26 Session check
         * 세션의 유저와 삭제될 유저가 동일한지 확인
         */

        userRepository.deleteById(user.id)
        return CheckDTO(
            success = true
        )
    }
}