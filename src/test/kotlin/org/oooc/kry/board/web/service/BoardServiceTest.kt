package org.oooc.kry.board.web.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.oooc.kry.board.domain.dto.BoardCreateRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetRequestDTO
import org.oooc.kry.board.domain.entity.Article
import org.oooc.kry.board.web.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class BoardServiceTest(
    @Autowired var boardRepository: BoardRepository,
    @Autowired var boardService: BoardService
) {
    @Test
    fun create_board_test() {
        // given
        var boardCreateRequestDTO = BoardCreateRequestDTO(name = "board1", seq = 1)

        // when
        boardService.createBoard(boardCreateRequestDTO)

        // then
        var boardGetRequestDTO = BoardGetRequestDTO(boardName = "board1")
        var boardGetResponseDTO = boardService.getBoard(boardGetRequestDTO)
        Assertions.assertThat(boardGetResponseDTO.name).isEqualTo(boardCreateRequestDTO.name)
    }

    @Test
    @Commit
    @Transactional
            /**
             * ArticleController 구현 후 재작성 및 테스트 필요
             */
    fun MANUAL_TEST_get_board_test() {
        // given
//        boardService.createBoard(BoardCreateRequestDTO(name = "board2", seq = 2))
        var boardGetRequestDTO = BoardGetRequestDTO("board2")

        // when
        var resp = boardService.getBoard(boardGetRequestDTO)

        // then
        println(resp.id)
        println(resp.name)
        println(resp.seq)
        for (item:Article in resp.articles) {
            println(item.content)
        }
    }
}
