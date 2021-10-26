package org.oooc.kry.auth.web.service

import org.oooc.kry.auth.domain.dto.PermgroupAddDTO
import org.oooc.kry.auth.domain.dto.PermgroupDTO
import org.oooc.kry.auth.domain.dto.PermissionDTO
import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.exception.PermgroupNotFoundException
import org.oooc.kry.auth.web.repository.PermgroupRepository
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PermgroupService(
    private val permgroupRepository: PermgroupRepository,
    ) {
    fun getPermgroupList(): List<PermgroupDTO> {
        val permgroups = permgroupRepository.findAll()
        val permgroupDTOs = permgroups.map { permgroup ->
            PermgroupDTO(
                id = permgroup.id,
                name = permgroup.name,
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

    fun deletePermgroup(permgroupId: Long): CheckDTO {
        val permgroup = permgroupRepository.findByIdOrNull(permgroupId) ?: throw PermgroupNotFoundException()

        permgroupRepository.deleteById(permgroup.id)

        return CheckDTO(
            success = true
        )
    }
}