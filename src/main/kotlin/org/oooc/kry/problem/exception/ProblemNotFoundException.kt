package org.oooc.kry.problem.exception

import org.oooc.kry.global.exception.ObjectNotFoundException

class ProblemNotFoundException(message: String = "문제를 찾을 수 없습니다.") : ObjectNotFoundException(message)
