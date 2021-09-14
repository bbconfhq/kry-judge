package org.oooc.kry.auth.domain.dto

import javax.validation.constraints.NotEmpty

interface PremgroupGetResponseDTO {
    val name: String
}

data class PermgroupPostRequestDTO(
    @field:NotEmpty val name: String
)

data class PermgroupPostResponseDTO(
    val name: String = ""
)

interface PremgroupPutResponseDTO {
    val name: String
}

