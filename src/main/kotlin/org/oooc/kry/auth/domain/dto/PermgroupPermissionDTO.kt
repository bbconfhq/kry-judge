package org.oooc.kry.auth.domain.dto

import org.oooc.kry.auth.domain.entity.Permgroup
import org.oooc.kry.auth.domain.entity.Permission

data class PermgroupPermissionDTO(
    val permgroup: Permgroup,
    val permission: Permission
)
