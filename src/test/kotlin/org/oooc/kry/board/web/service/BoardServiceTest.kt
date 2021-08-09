package org.oooc.kry.board.web.service

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.oooc.kry.board.domain.dto.BoardCreateRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetRequestDTO
import org.oooc.kry.board.domain.entity.Article
import org.oooc.kry.board.domain.entity.Board
import org.oooc.kry.board.web.repository.BoardRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.Commit
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
class BoardServiceTest(
    @Autowired var boardService: BoardService,
) {

    val boardRepository = boardService.boardRepository

    @Test
    fun create_board_test() {
        val boardRepository = boardService.boardRepository

        // given
        boardService.createBoard("board1", 10)

        // when
        val board = Board(name="board1", seq=10)

        // then
        Assertions.assertThat(board.name)
            .isEqualTo(boardRepository.findByName("board1")!!.name)
        Assertions.assertThat(board.seq)
            .isEqualTo(boardRepository.findByName("board1")!!.seq)
    }

    @Test
    //@Commit
    @Transactional
            /**
             * ArticleController 구현 후 재작성 및 테스트 필요
             */
    fun MANUAL_TEST_get_board_test() {
        // given

        // when
        var resp = boardService.getBoard("board2")

        // then
        println(resp.id)
        println(resp.name)
        println(resp.seq)
        for (item:Article in resp.articles) {
            println(item.content)
        }
    }

    @Test
    @Transactional
    fun modifyBoardTest() {
        val board4 = Board(name="board4", seq=200)
        boardRepository.save(board4)

        boardService.modifyBoard("board4", "board5", 500)

        val board3 = boardRepository.findByName("board5")
        Assertions.assertThat(board3.name).isEqualTo("board5")
    }

    @Test
    @Transactional
//    @Commit
    fun MANUAL_TEST_deleteBoardTest() {

        val board9 = Board(name="board9", seq=900)
        val board10 = Board(name="board10", seq=1000)
        boardRepository.save(board9)
        boardRepository.save(board10)

        boardService.deleteBoard("board10")
    }

    @Test
    @Transactional
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
