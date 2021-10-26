package org.oooc.kry.auth.domain.dto

data class PermgroupPermissionDTO(
    val permgroup: PermgroupDTO,
    val permission: PermissionDTO
)

data class PermgroupPermissionAddDTO(
    val permgroup: PermgroupDTO,
    val permission: PermissionDTO
)

data class PermgroupPermissionDeleteDTO(
    val permgroup: PermgroupDTO,
    val permission: PermissionDTO
)
