package org.oooc.kry.user.domain.dto

data class UserAddDTO(
    val name: String = "",
    val pw: String = "",
    val nick: String = "",
    val email: String = "",
    val bio: String = ""
)
