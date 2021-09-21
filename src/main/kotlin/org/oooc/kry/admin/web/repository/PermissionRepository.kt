package org.oooc.kry.admin.web.repository

import org.oooc.kry.admin.domain.entity.Permission
import org.springframework.data.jpa.repository.JpaRepository

interface PermissionRepository: JpaRepository<Permission, Long> {
}