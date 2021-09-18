package org.oooc.kry.auth.web.service

import org.oooc.kry.auth.domain.dto.*
import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.entity.PermgroupPermission
import org.oooc.kry.auth.domain.entity.Permission
import org.oooc.kry.auth.domain.exception.PermgroupNotFoundException
import org.oooc.kry.auth.domain.exception.PermissionNotFoundException
import org.oooc.kry.auth.web.repository.*
import org.oooc.kry.global.dto.APIResponse
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AuthService (
    private val permgroupPermissionRepository: PermgroupPermissionRepository,
    private val permgroupRepository: PermgroupRepository,
    private val permissionRepository: PermissionRepository,
    private val userPermgroupRepository: UserPermgroupRepository,
    private val userPermissionRepository: UserPermissionRepository
) {
    fun getPermgroupList(): List<PermgroupDTO> {
        val permgroups = permgroupRepository.findAll()
        val permgroupDTOs = permgroups.map { permgroup ->
            val permissions = permgroupPermissionRepository.findAllByPermgroup(permgroup).map { it.permission }
            PermgroupDTO(
                id = permgroup.id,
                name = permgroup.name,
                permissions = permissions
            )
        }

        return permgroupDTOs
    }

    fun addPermgroup(name: String): PermgroupDTO {
        val permgroup = permgroupRepository.save(
            Permgroup(
                name = name
            )
        )
        return PermgroupDTO(
            id = permgroup.id,
            name = permgroup.name
        )
    }

    fun updatePermgroup(permgroupUpdateDTO: PermgroupUpdateDTO): PermgroupDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupUpdateDTO.id) ?: throw PermgroupNotFoundException()
        val newPermgroup = permgroup.apply {
            name = permgroupUpdateDTO.name
        }
        return PermgroupDTO(
            id = newPermgroup.id,
            name = newPermgroup.name
        )
    }

    fun getPermissionList(): List<PermissionDTO> {
        val permissions = permissionRepository.findAll()
        val permissionDTOs = permissions.map { permission ->
            PermissionDTO(permission.id, permission.name)
        }

        return permissionDTOs
    }

    fun addPermission(name: String): PermissionDTO {
        val permission = permissionRepository.save(
            Permission(
                name = name
            )
        )

        return PermissionDTO(
            id = permission.id,
            name = permission.name
        )
    }

    fun updatePermission(permissionUpdateDTO: PermissionUpdateDTO): PermissionDTO {
        val permission = permissionRepository.findByIdOrNull(permissionUpdateDTO.id) ?: throw PermissionNotFoundException()
        val newPermission = permission.apply {
            name = permissionUpdateDTO.name
        }

        return PermissionDTO(
            id = newPermission.id,
            name = newPermission.name
        )
    }

    fun addPermissionToPermgroup(permgroupPermissionAddDTO: PermgroupPermissionAddDTO): PermgroupPermissionDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupPermissionAddDTO.permgroupId) ?: throw PermgroupNotFoundException()
        val permission = permissionRepository.findByIdOrNull(permgroupPermissionAddDTO.permissionId) ?: throw PermissionNotFoundException()

        val permgroupPermission = permgroupPermissionRepository.save(
            PermgroupPermission(
                permgroup = permgroup,
                permission = permission
            )
        )

        return PermgroupPermissionDTO(
            permgroup = permgroupPermission.permgroup,
            permission = permgroupPermission.permission
        )
    }
}