package org.oooc.kry.auth.web.service

import org.oooc.kry.auth.domain.dto.*
import org.oooc.kry.auth.domain.entity.PermgroupPermission
import org.oooc.kry.auth.domain.entity.PermgroupPermissionId
import org.oooc.kry.auth.domain.exception.PermgroupNotFoundException
import org.oooc.kry.auth.domain.exception.PermissionNotFoundException
import org.oooc.kry.auth.web.repository.PermgroupPermissionRepository
import org.oooc.kry.auth.web.repository.PermgroupRepository
import org.oooc.kry.auth.web.repository.PermissionRepository
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PermgroupPermissionService(
    private val permgroupPermissionRepository: PermgroupPermissionRepository,
    private val permgroupRepository: PermgroupRepository,
    private val permissionRepository: PermissionRepository
) {
    fun addPermissionToPermgroup(permgroupId: Long, permissionId: Long): PermgroupPermissionDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupId) ?: throw PermgroupNotFoundException()
        val permission = permissionRepository.findByIdOrNull(permissionId) ?: throw PermissionNotFoundException()

        val permgroupPermission = permgroupPermissionRepository.save(
            PermgroupPermission(
                permgroup = permgroup,
                permission = permission
            )
        )

        return PermgroupPermissionDTO(
            permgroup = PermgroupDTO(
                id = permgroupPermission.permgroup.id,
                name = permgroupPermission.permgroup.name
            ),
            permission = PermissionDTO(
                id = permgroupPermission.permission.id,
                name = permgroupPermission.permission.name
            )
        )
    }

    fun deletePermissionFromPermgroup(permgroupId: Long, permissionId: Long): CheckDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupId) ?: throw PermgroupNotFoundException()
        val permission = permissionRepository.findByIdOrNull(permissionId) ?: throw PermissionNotFoundException()

        permgroupPermissionRepository.deleteById(
            PermgroupPermissionId(
                permgroup = permgroup.id,
                permission = permission.id
            )
        )
        return CheckDTO(
            success = true
        )
    }
}