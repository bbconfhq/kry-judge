package org.oooc.kry.auth.domain.exception

class PermissionNotFoundException(message: String = "해당 권한을 찾을 수 없습니다."): RuntimeException(message)
