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
        val user = userRepository.findByNickOrNull(nick) ?: throw UserNotFoundException()
        return UserPublicDTO(
            user.nick,
            user.email,
            user.bio
        )
    }

    fun getUserPrivate(): UserPrivateDTO {
        val user = User()

        /** TODO(Jerry): 2021-08-26
         * Session check
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
        var newUser = userRepository.findByNameOrNull(userUpdateDTO.name) ?: throw UserNotFoundException()

        /** TODO(Jerry): 2021-08-26
         * Session check
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
        val user = userRepository.findByNameOrNull(userDeleteDTO.name) ?: throw UserNotFoundException()

        /** TODO(Jerry): 2021-08-26
         * Session check
         */

        userRepository.deleteById(user.id)
        return CheckDTO(
            success = true
        )
    }
}