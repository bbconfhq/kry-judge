package org.oooc.kry.board.web.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.oooc.kry.board.domain.entity.Article
import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.exception.BoardNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@Transactional
class BoardServiceTest(
    @Autowired
    val boardService: BoardService
) {

    val boardRepository = boardService.boardRepository

    @Test
    fun create_board_test() {
        val boardRepository = boardService.boardRepository

        // given
        boardService.createBoard("board1", 1)

        // when
        val board = Board(name="board1", seq=1)

        // then
        val res = boardRepository.findByName(board.name) ?: throw BoardNotFoundException()
        Assertions.assertThat(board.name)
            .isEqualTo(res.name)
        Assertions.assertThat(board.seq)
            .isEqualTo(res.seq)
    }

    @Test
    fun modifyBoardTest() {
        val board2 = Board(name="board2", seq=2)
        boardRepository.save(board2)

        boardService.modifyBoard("board2", "board20", 20)

        val findBoard = boardRepository.findByName("board20") ?: throw BoardNotFoundException()
        Assertions.assertThat(findBoard.name).isEqualTo("board20")
    }

    @Test
    fun boardListTest() {
        val board1 = Board(name="board11",seq=110)
        val board2 = Board(name="board12",seq=120)
        val board3 = Board(name="board13",seq=130)
        boardRepository.save(board1)
        boardRepository.save(board2)
        boardRepository.save(board3)

        val boardList = boardService.getBoardList()

        Assertions.assertThat(boardList.size).isEqualTo(3)
    }
}
