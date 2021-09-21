package org.oooc.kry.user.domain.dto

data class UserAddDTO(
    val name: String = "",
    val pw: String = "",
    val nick: String = "",
    val email: String = "",
    val bio: String = ""
)

data class UserPrivateDTO(
    val name: String = "",
    val nick: String = "",
    val email: String = "",
    val bio: String = "",
)

data class UserPublicDTO(
    val nick: String = "",
    val email: String = "",
    val bio: String = "",
)

data class UserUpdateDTO(
    val name: String = "",
    val pw: String = "",
    val nick: String = "",
    val email: String = "",
    val bio: String = "",
)

data class UserDeleteDTO(
    val name: String = "",
    val pw: String = "",
)
