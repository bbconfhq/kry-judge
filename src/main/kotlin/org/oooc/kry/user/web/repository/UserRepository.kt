package org.oooc.kry.user.web.repository

import org.oooc.kry.user.domain.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository: JpaRepository<User, Long> {
    fun findByName(name: String): User?
    fun findByNick(name: String): User?
    fun existsByName(name: String): Boolean
    fun existsByNick(nick: String): Boolean
    fun existsByEmail(email: String): Boolean
}