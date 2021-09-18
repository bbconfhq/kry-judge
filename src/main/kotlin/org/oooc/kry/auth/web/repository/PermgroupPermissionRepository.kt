package org.oooc.kry.auth.web.repository

import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.entity.PermgroupPermission
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PermgroupPermissionRepository: JpaRepository<PermgroupPermission, Long> {
    fun findAllByPermgroup(permgroup: Permgroup): List<PermgroupPermission>
}