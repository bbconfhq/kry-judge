package org.oooc.kry.auth.web.repository

import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.entity.Permission
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PermissionRepository: JpaRepository<Permission, Long> {
    fun findByName(name: String): Permission?
}