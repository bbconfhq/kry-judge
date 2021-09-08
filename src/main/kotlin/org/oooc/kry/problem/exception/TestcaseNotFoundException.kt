package org.oooc.kry.problem.exception

import org.oooc.kry.global.exception.ObjectNotFoundException

class TestcaseNotFoundException(message: String = "테스트케이스를 찾을 수 없습니다.") : ObjectNotFoundException(message)
