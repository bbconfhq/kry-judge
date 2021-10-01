package org.oooc.kry.board.exception

class BoardNotFoundException(message: String = "게시판을 찾을 수 없습니다.") : RuntimeException(message)