package org.oooc.kry.admin.web.service

import org.oooc.kry.admin.domain.dto.*
import org.oooc.kry.admin.domain.entity.Permgroup
import org.oooc.kry.admin.domain.entity.PermgroupPermission
import org.oooc.kry.admin.domain.entity.PermgroupPermissionId
import org.oooc.kry.admin.domain.entity.Permission
import org.oooc.kry.admin.domain.exception.PermgroupNotFoundException
import org.oooc.kry.admin.domain.exception.PermissionNotFoundException
import org.oooc.kry.admin.web.repository.*
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AdminService (
    private val permgroupPermissionRepository: PermgroupPermissionRepository,
    private val permgroupRepository: PermgroupRepository,
    private val permissionRepository: PermissionRepository,
    private val userPermgroupRepository: UserPermgroupRepository,
) {
    fun getPermgroupList(): List<PermgroupDTO> {
        val permgroups = permgroupRepository.findAll()
        val permgroupDTOs = permgroups.map { permgroup ->
            PermgroupDTO(
                id = permgroup.id,
                name = permgroup.name,
//                permissions = permgroup.permgroupPermissions.map { PermissionDTO(it.permission.id, it.permission.name)}
            )
        }

        return permgroupDTOs
    }

    fun getPermissionsOfPermgroup(permgroupId: Long): List<PermissionDTO> {
        val permgroups = permgroupRepository.findByIdOrNull(permgroupId) ?: throw PermgroupNotFoundException()
        val permissionDTOs = permgroups.permgroupPermissions.map { permgroupPermission ->
            PermissionDTO(
                id = permgroupPermission.permission.id,
                name = permgroupPermission.permission.name
            )
        }

        return permissionDTOs
    }

    fun addPermgroup(permgroupAddDTO: PermgroupAddDTO): PermgroupDTO {
        val permgroup = permgroupRepository.save(
            Permgroup(
                name = permgroupAddDTO.name
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

    fun deletePermgroup(permgroupId: Long): CheckDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupId) ?: throw PermgroupNotFoundException()

        permgroupRepository.deleteById(permgroup.id)

        return CheckDTO(
            success = true
        )
    }

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

    fun updatePermission(permissionId:Long, permissionUpdateDTO: PermissionUpdateDTO): PermissionDTO {
        val permission = permissionRepository.findByIdOrNull(permissionId) ?: throw PermissionNotFoundException()
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

    fun deletePermissionFromPermgroup(permgroupPermissionDeleteDTO: PermgroupPermissionDeleteDTO): CheckDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupPermissionDeleteDTO.permgroupId) ?: throw PermgroupNotFoundException()
        val permission = permissionRepository.findByIdOrNull(permgroupPermissionDeleteDTO.permissionId) ?: throw PermissionNotFoundException()

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