package org.oooc.kry.auth.domain.dto

interface PermissionGetResponseDTO {
    val name: String
}

data class PermissionPostResponseDTO (
    val name: String = ""
)
