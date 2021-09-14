package org.oooc.kry.auth.domain.repository

import org.oooc.kry.auth.domain.entity.PermgroupPermission
import org.oooc.kry.auth.domain.entity.PermgroupPermissionId
import org.springframework.data.jpa.repository.JpaRepository

interface PermgroupPermissionRepository: JpaRepository<PermgroupPermission, PermgroupPermissionId> {
}