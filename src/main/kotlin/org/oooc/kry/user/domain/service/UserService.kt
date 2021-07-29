package org.oooc.kry.user.domain.service

import javassist.NotFoundException
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.domain.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(userId: Long) = userRepository.findById(userId).orElseThrow{NotFoundException("notfound")}
    fun createUser(user: User) = userRepository.save(user)
}