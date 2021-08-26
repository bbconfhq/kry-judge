package org.oooc.kry.user.web.exception

class UserNotFoundException(message: String = "유저를 찾을 수 없습니다.") : RuntimeException(message)
class NotFoundException(message: String = "유저를 찾을 수 없습니다.") : RuntimeException(message)
