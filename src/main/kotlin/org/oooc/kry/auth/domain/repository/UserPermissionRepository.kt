package org.oooc.kry.auth.domain.repository

import org.oooc.kry.auth.domain.entity.UserPermission
import org.oooc.kry.auth.domain.entity.UserPermissionId
import org.springframework.data.jpa.repository.JpaRepository

interface UserPermissionRepository: JpaRepository<UserPermission, UserPermissionId> {
}