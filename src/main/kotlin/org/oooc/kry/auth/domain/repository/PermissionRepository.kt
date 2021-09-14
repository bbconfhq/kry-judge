package org.oooc.kry.auth.domain.repository

import org.oooc.kry.auth.domain.dto.PermissionGetResponseDTO
import org.oooc.kry.auth.domain.entity.Permission
import org.springframework.data.jpa.repository.JpaRepository

interface PermissionRepository: JpaRepository<Permission, Long> {
    fun findAllGetResponseDTOProjectionBy(): List<PermissionGetResponseDTO>
}