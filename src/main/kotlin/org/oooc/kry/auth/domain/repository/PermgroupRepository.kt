package org.oooc.kry.auth.domain.repository

import org.oooc.kry.auth.domain.entity.Permgroup
import org.springframework.data.jpa.repository.JpaRepository

interface PermgroupRepository: JpaRepository<Permgroup, Long> {
}