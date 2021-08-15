package org.oooc.kry.user.web.service

import javassist.NotFoundException
import org.oooc.kry.global.ResourceNotFoundException
import org.oooc.kry.user.domain.entity.User
import org.oooc.kry.user.domain.repository.UserRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import org.springframework.web.bind.MethodArgumentNotValidException
import javax.annotation.Resource
import kotlin.reflect.KProperty

@Service
class UserService(private val userRepository: UserRepository) {
    fun findAll(sort: Sort) = userRepository.findAll(sort)
    fun createUser(user: User) = userRepository.save(user)
    fun getUserByNick(nick: String) = userRepository.findByNick(nick)
    fun getUserByName(name: String) = userRepository.findByName(name)
    fun updateUser(user: User) = userRepository.save(user)
    fun deleteUser(name: String){
        val id = userRepository.findByName(name)?.id ?: throw ResourceNotFoundException()
        userRepository.deleteById(id)
    }

    fun errorTest1(payload: String): Nothing{
        throw ResourceNotFoundException()
    }
}