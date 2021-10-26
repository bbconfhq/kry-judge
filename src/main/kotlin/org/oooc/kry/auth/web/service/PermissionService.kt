package org.oooc.kry.auth.web.service

import org.oooc.kry.auth.domain.dto.PermissionAddDTO
import org.oooc.kry.auth.domain.dto.PermissionDTO
import org.oooc.kry.auth.domain.entity.Permission
import org.oooc.kry.auth.domain.exception.PermgroupNotFoundException
import org.oooc.kry.auth.domain.exception.PermissionNotFoundException
import org.oooc.kry.auth.web.repository.PermissionRepository
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PermissionService(
    private val permissionRepository: PermissionRepository
) {
    fun getPermissionList(): List<PermissionDTO> {
        val permissions = permissionRepository.findAll()
        val permissionDTOs = permissions.map { permission ->
            PermissionDTO(permission.id, permission.name)
        }

        return permissionDTOs
    }

    fun addPermission(permissionAddDTO: PermissionAddDTO): PermissionDTO {
        val permission = permissionRepository.save(
            Permission(
                name = permissionAddDTO.name
            )
        )

        return PermissionDTO(
            id = permission.id,
            name = permission.name
        )
    }

    fun deletePermission(permissionId: Long): CheckDTO {
        val permission = permissionRepository.findByIdOrNull(permissionId) ?: throw PermissionNotFoundException()

        permissionRepository.deleteById(permission.id)

        return CheckDTO(
            success = true
        )
    }
}