package org.oooc.kry.auth.domain.dto

data class PermissionDTO(
    val id: Long = 0,
    val name: String = ""
)

data class PermissionAddDTO(
    val name: String = ""
)
