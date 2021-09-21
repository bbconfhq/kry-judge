package org.oooc.kry.auth.web.repository

import org.oooc.kry.auth.domain.entity.Permgroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PermgroupRepository: JpaRepository<Permgroup, Long> {
    fun findByName(name: String): Permgroup?
}