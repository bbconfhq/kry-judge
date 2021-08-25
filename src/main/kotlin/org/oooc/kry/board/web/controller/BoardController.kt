package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.*
import org.oooc.kry.board.web.service.BoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class BoardController(
    val boardService: BoardService
) {

    // CREATE BOARD
    @PostMapping("/")
    fun postBoard(
        @RequestBody boardCreateRequestDTO: BoardCreateRequestDTO
    ) {
        boardService.createBoard(boardCreateRequestDTO.name, boardCreateRequestDTO.seq)
    }

    // GET BOARD
    @GetMapping("/{boardName}")
    fun getBoard(
        @PathVariable boardName: String
    ): BoardGetResponseDTO {
        val board = boardService.getBoard(boardName)
        return BoardGetResponseDTO(id = board.id, name = board.name, seq = board.seq, articles = board.articles)
    }

    // MODIFY BOARD
    @PutMapping("/{boardName}")
    fun putBoard(
        @PathVariable boardName: String,
        @RequestBody boardPutRequestDTO: BoardPutRequestDTO
    ) {
        boardService.modifyBoard(boardName, boardPutRequestDTO.name, boardPutRequestDTO.seq)
    }

    // DELETE BOARD
    @DeleteMapping("/{boardName}")
    fun deleteBoard(
        @PathVariable boardName: String
    ) {
        boardService.deleteBoard(boardName)
    }

    // GET LIST OF BOARDS
    @GetMapping("/")
    fun getBoards(): BoardsGetResponseDTO {
        val boardsList = boardService.getBoardList()
        return BoardsGetResponseDTO(boardsList)
    }

}
