package org.oooc.kry.board.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.oooc.kry.board.domain.dto.BoardCreateRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetRequestDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BoardServiceTest {

    val boardService: BoardService = BoardService()

    @Test
    fun 게시판_생성() {
        // given
        var boardCreateRequestDTO = BoardCreateRequestDTO(name = "board1", seq = 1)

        // when
        boardService.createBoard(boardCreateRequestDTO)

        // then
        var boardGetRequestDTO = BoardGetRequestDTO(boardName = "board1")
        var boardGetResponseDTO = boardService.getBoard(boardGetRequestDTO)
        Assertions.assertThat(boardGetResponseDTO.name).isEqualTo(boardCreateRequestDTO.name)
    }

}
