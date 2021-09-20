package org.oooc.kry.auth.web.repository

import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.entity.PermgroupPermission
import org.oooc.kry.auth.domain.entity.PermgroupPermissionId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PermgroupPermissionRepository: JpaRepository<PermgroupPermission, PermgroupPermissionId> {
    fun findAllByPermgroup(permgroup: Permgroup): List<PermgroupPermission>
}