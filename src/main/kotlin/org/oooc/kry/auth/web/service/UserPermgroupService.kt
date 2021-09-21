package org.oooc.kry.auth.web.service

import org.oooc.kry.auth.domain.dto.PermgroupDTO
import org.oooc.kry.auth.domain.dto.UserPermgroupAddDTO
import org.oooc.kry.auth.domain.dto.UserPermgroupDTO
import org.oooc.kry.auth.domain.dto.UserPermgroupDeleteDTO
import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.entity.UserPermgroup
import org.oooc.kry.auth.domain.entity.UserPermgroupId
import org.oooc.kry.auth.domain.exception.PermgroupNotFoundException
import org.oooc.kry.auth.web.repository.PermgroupRepository
import org.oooc.kry.auth.web.repository.UserPermgroupRepository
import org.oooc.kry.global.dto.CheckDTO
import org.oooc.kry.user.domain.dto.UserAuthDTO
import org.oooc.kry.user.domain.exception.UserNotFoundException
import org.oooc.kry.user.web.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class UserPermgroupService(
    private val userPermgroupRepository: UserPermgroupRepository,
    private val userRepository: UserRepository,
    private val permgroupRepository: PermgroupRepository
) {

    fun addUserToPermgroup(permgroupId: Long, userId: Long): UserPermgroupDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupId) ?: throw PermgroupNotFoundException()
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()

        val userPermgroup = userPermgroupRepository.save(
            UserPermgroup(
                permgroup = permgroup,
                user = user,
            )
        )

        return UserPermgroupDTO(
            user = UserAuthDTO(
                id = userPermgroup.user.id,
                nick = userPermgroup.user.nick
            ),
            permgroup = PermgroupDTO(
                id = userPermgroup.permgroup.id,
                name = userPermgroup.permgroup.name
            )
        )
    }

    fun deleteUserFromPermgroup(permgroupId: Long, userId: Long): CheckDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupId) ?: throw PermgroupNotFoundException()
        val user = userRepository.findByIdOrNull(userId) ?: throw UserNotFoundException()

        userPermgroupRepository.deleteById(
            UserPermgroupId(
                permgroup = permgroup.id,
                user = user.id,
            )
        )

        return CheckDTO(
            success = true
        )
    }
}