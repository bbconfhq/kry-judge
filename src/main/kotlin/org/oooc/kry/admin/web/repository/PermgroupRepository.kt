package org.oooc.kry.admin.web.repository

import org.oooc.kry.admin.domain.entity.Permgroup
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PermgroupRepository: JpaRepository<Permgroup, Long> {
}