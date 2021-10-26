package org.oooc.kry.auth.domain.dto

import org.oooc.kry.user.domain.dto.UserAuthDTO

data class UserPermgroupDTO(
    val user: UserAuthDTO = UserAuthDTO(),
    val permgroup: PermgroupDTO = PermgroupDTO(),
)

data class UserPermgroupAddDTO(
    val userId: Long = 0,
    val permgroupId: Long = 0
)

data class UserPermgroupDeleteDTO(
    val userId: Long = 0,
    val permgroupId: Long = 0
)
