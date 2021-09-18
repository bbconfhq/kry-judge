package org.oooc.kry.auth.web.repository

import org.oooc.kry.auth.domain.entity.Permission
import org.springframework.data.jpa.repository.JpaRepository

interface PermissionRepository: JpaRepository<Permission, Long> {
}