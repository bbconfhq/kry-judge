package org.oooc.kry.auth.domain.dto

import org.oooc.kry.auth.domain.entity.Permission

data class PermgroupDTO(
    val id: Long = 0,
    val name: String = "",
    val permissions: List<Permission> = emptyList()
)
