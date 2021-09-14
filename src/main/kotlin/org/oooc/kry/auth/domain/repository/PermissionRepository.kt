package org.oooc.kry.auth.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import java.security.Permission

interface PermissionRepository: JpaRepository<Permission, Long> {
}