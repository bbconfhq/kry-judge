package org.oooc.kry.auth.web.repository

import org.oooc.kry.auth.domain.entity.UserPermgroup
import org.oooc.kry.auth.domain.entity.UserPermgroupId
import org.springframework.data.jpa.repository.JpaRepository

interface UserPermgroupRepository: JpaRepository<UserPermgroup, UserPermgroupId> {
}