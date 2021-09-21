package org.oooc.kry.auth.domain.dto

data class PermgroupPermissionDTO(
    val permgroup: PermgroupDTO,
    val permission: PermissionDTO
)

data class PermgroupPermissionAddDTO(
    val permgroupId: Long,
    val permissionId: Long
)

data class PermgroupPermissionDeleteDTO(
    val permgroupId: Long = 0,
    val permissionId: Long = 0
)
