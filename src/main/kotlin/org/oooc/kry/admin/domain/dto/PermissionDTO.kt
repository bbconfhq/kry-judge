package org.oooc.kry.admin.domain.dto

data class PermissionDTO(
    val id: Long = 0,
    val name: String = ""
)

data class PermissionUpdateDTO(
    val name: String = ""
)

data class PermissionAddDTO(
    val name: String = ""
)
