package org.oooc.kry.user.web

import net.bytebuddy.TypeCache
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.domain.repository.UserRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(userId: Long) = userRepository.findById(userId)

    fun saveUser(user: User) = userRepository.save(user)

    fun findAll(sort: Sort) = userRepository.findAll(sort)
}