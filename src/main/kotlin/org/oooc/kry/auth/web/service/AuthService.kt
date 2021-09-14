package org.oooc.kry.auth.web.service

import org.oooc.kry.auth.domain.dto.PermgroupDto
import org.oooc.kry.auth.domain.repository.PermgroupPermissionRepository
import org.oooc.kry.auth.domain.repository.PermgroupRepository
import org.oooc.kry.auth.domain.repository.UserPermgroupRepository
import org.oooc.kry.auth.domain.repository.UserPermissionRepository
import org.springframework.stereotype.Service

@Service
class AuthService (
    private val permgroupPermissionRepository: PermgroupPermissionRepository,
    private val permgroupRepository: PermgroupRepository,
    private val permissionRepository: PermgroupPermissionRepository,
    private val userPermgroupRepository: UserPermgroupRepository,
    private val userPermissionRepository: UserPermissionRepository
) {
    fun getPermgroupList(): List<PermgroupDto> {
        return permgroupRepository.findAllDTOProjectionBy()
    }
}