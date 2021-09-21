package org.oooc.kry.admin.domain.exception

class PermgroupNotFoundException(message: String = "해당 권한 그룹을 찾을 수 없습니다."): RuntimeException(message)
