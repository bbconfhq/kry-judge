package org.oooc.kry.auth.web.service

import org.oooc.kry.auth.domain.dto.*
import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.repository.*
import org.springframework.stereotype.Service

@Service
class AuthService (
    private val permgroupPermissionRepository: PermgroupPermissionRepository,
    private val permgroupRepository: PermgroupRepository,
    private val permissionRepository: PermissionRepository,
    private val userPermgroupRepository: UserPermgroupRepository,
    private val userPermissionRepository: UserPermissionRepository
) {
    fun getPermgroupList(): List<PermgroupGetResponseDTO> {
        return permgroupRepository.findAllResponseDTOProjectionBy()
    }

    fun addPermgroup(permgroupPostRequestDTO: PermgroupPostRequestDTO): PermgroupPostResponseDTO {
        val permgroup = permgroupRepository.save(
            Permgroup(
                name = permgroupPostRequestDTO.name
            )
        )

        return PermgroupPostResponseDTO(
            permgroup.name
        )
    }

    fun getPermissionList(): List<PermissionGetResponseDTO> {
        return permissionRepository.findAllGetResponseDTOProjectionBy()
    }
}