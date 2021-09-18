package org.oooc.kry.auth.web.service

import org.oooc.kry.auth.domain.dto.*
import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.entity.Permission
import org.oooc.kry.auth.domain.exception.PermgroupNotFoundException
import org.oooc.kry.auth.web.repository.*
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
            PermgroupDTO(permgroup.id, permgroup.name)
        }

        return permgroupDTOs
    }

    fun addPermgroup(name: String): PermgroupDTO {
        val permgroup = permgroupRepository.save(Permgroup(name = name))
        return PermgroupDTO(id = permgroup.id, name = permgroup.name)
    }

    fun updatePermgroup(permgroupUpdateDTO: PermgroupUpdateDTO) {
        val newPermgroup = permgroupRepository.findByIdOrNull(permgroupUpdateDTO.id) ?: throw PermgroupNotFoundException()
        newPermgroup.apply {
            name = permgroupUpdateDTO.name
        }
    }

    fun getPermissionList(): List<PermissionDTO> {
        val permissions = permissionRepository.findAll()
        val permissionDTOs = permissions.map { permission->
            PermissionDTO(permission.id, permission.name)
        }

        return permissionDTOs
    }

    fun addPermission(name: String): PermissionDTO {
        val permission = permissionRepository.save(Permission(name = name))
        return PermissionDTO(id = permission.id, name = permission.name)
    }
}