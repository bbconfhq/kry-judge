package org.oooc.kry.user.web.service

import org.oooc.kry.global.dto.CheckDTO
import org.oooc.kry.user.domain.dto.*
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.web.repository.UserRepository
import org.oooc.kry.user.domain.exception.UserNotFoundException
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    /** TODO(Jerry): 2021-09-14 Add find all feature
     * fun findAll(sort: Sort) = userRepository.findAll(sort)
     */

    fun getUserPublic(nick: String): UserPublicDTO {
        val user = userRepository.findByNick(nick) ?: throw UserNotFoundException()
        return UserPublicDTO(
            user.nick,
            user.email,
            user.bio
        )
    }

    fun getUserPrivate(name: String): UserPrivateDTO {
        val user = userRepository.findByName(name) ?: throw UserNotFoundException()

        return  UserPrivateDTO(
            user.name,
            user.nick,
            user.email,
            user.bio
        )
    }

    fun addUser(userAddDTO: UserAddDTO): UserPrivateDTO {
        val user = userRepository.save(
            User(
                name = userAddDTO.name,
                /** TODO(Jerry): 2021-08-26 hashing password
                 * pw = passwordEncoder.encode(userAddDTO.pw)
                 */
                pw = userAddDTO.pw,
                nick = userAddDTO.nick,
                email = userAddDTO.email,
                bio = userAddDTO.bio
            )
        )

        return UserPrivateDTO(
            user.name,
            user.nick,
            user.email,
            user.bio
        )
    }

    fun updateUser(userUpdateDTO: UserUpdateDTO): UserPrivateDTO {
        val user = userRepository.findByName(userUpdateDTO.name) ?: throw UserNotFoundException()

        /** TODO(Jerry): 2021-08-26 Session check
         * 세션의 유저와 업데이트할 유저가 동일한지 확인
         */

        val newUser = user.apply {
            /** TODO(Jerry): 2021-08-26 hashing password
             * pw = passwordEncoder.encode(userUpdateDTO.pw)
             */
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

        /** TODO(Jerry): 2021-08-27
         * 비밀번호 일치 확인
         */
//        if(!passwordEncoder.matches(userDeleteDTO.pw, user.pw))
//            throw WrongPasswordException()


        /** TODO(Jerry): 2021-08-26 Session check
         * 세션의 유저와 삭제될 유저가 동일한지 확인
         */

        userRepository.deleteById(user.id)
        return CheckDTO(
            success = true
        )
    }
}