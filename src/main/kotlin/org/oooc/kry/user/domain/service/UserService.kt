package org.oooc.kry.user.domain.service

import javassist.NotFoundException
import org.apache.kafka.common.requests.ApiError
import org.hibernate.annotations.NotFound
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.domain.repository.UserRepository
import org.springframework.data.crossstore.ChangeSetPersister
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun getUserById(userId: Long) = userRepository.findById(userId)

    fun createUser(user: User) = userRepository.save(user)
}