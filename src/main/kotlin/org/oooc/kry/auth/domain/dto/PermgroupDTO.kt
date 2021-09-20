package org.oooc.kry.auth.domain.dto

import org.oooc.kry.auth.domain.entity.Permission

data class PermgroupDTO(
    val id: Long = 0,
    val name: String = "",
)

data class PermgroupUpdateDTO(
    val id: Long = 0,
    val name: String = ""
)

data class PermgroupAddDTO(
    val name: String = "",
)
