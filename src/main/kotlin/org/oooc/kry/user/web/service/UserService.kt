package org.oooc.kry.user.web.service

import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.domain.repository.UserRepository
import org.oooc.kry.user.web.exception.UserNotFoundException
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class UserService(private val userRepository: UserRepository) {
    fun findAll(sort: Sort) = userRepository.findAll(sort)
    fun addUser(user: User) = userRepository.save(user)
    fun getUserByNick(nick: String) = userRepository.findByNick(nick)
    fun getUserByName(name: String) = userRepository.findByName(name)
    fun updateUser(user: User) = userRepository.save(user)
    fun deleteUser(name: String){
        val id = userRepository.findByName(name)?.id ?: throw UserNotFoundException()
        userRepository.deleteById(id)
    }

    fun errorTest1(payload: String): Nothing{
        throw UserNotFoundException()
    }
}