package org.oooc.kry.board.controller

import org.oooc.kry.board.domain.dto.BoardCreateRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetRequestDTO
import org.oooc.kry.board.domain.dto.BoardGetResponseDTO
import org.oooc.kry.board.service.BoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class BoardController(val boardService: BoardService) {

    // CREATE BOARD
    @PostMapping("/")
    fun postBoard(@RequestBody boardCreateRequestDTO: BoardCreateRequestDTO) {
        boardService.createBoard(boardCreateRequestDTO)
    }

    // GET BOARD
    @GetMapping("/{boardName}")
    fun getBoard(@PathVariable boardName: String): BoardGetResponseDTO {
        val boardGetRequestDTO = BoardGetRequestDTO(boardName)
        return boardService.getBoard(boardGetRequestDTO)
    }

    // MODIFY BOARD
    @PutMapping("/{boardName}")
    fun putBoard() {

    }

    // DELETE BOARD
    @DeleteMapping("/{boardName}")
    fun deleteBoard() {

    }

    // GET LIST OF BOARDS
    @GetMapping("/")
    fun getBoards() {

    }
}
