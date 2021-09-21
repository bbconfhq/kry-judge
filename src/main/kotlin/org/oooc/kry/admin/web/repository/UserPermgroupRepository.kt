package org.oooc.kry.admin.web.repository

import org.oooc.kry.admin.domain.entity.UserPermgroup
import org.oooc.kry.admin.domain.entity.UserPermgroupId
import org.springframework.data.jpa.repository.JpaRepository

interface UserPermgroupRepository: JpaRepository<UserPermgroup, UserPermgroupId> {
}