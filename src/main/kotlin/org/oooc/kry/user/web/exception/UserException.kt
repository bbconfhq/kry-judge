package org.oooc.kry.user.web.exception

class UserNotFoundException(message: String = "유저를 찾을 수 없습니다.") : RuntimeException(message)
class WrongPasswordException(message: String = "비밀번호가 일치하지 않습니다.") : RuntimeException(message)
