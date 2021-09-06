package org.oooc.kry.board.web.controller

import org.oooc.kry.board.domain.dto.*
import org.oooc.kry.board.web.service.BoardService
import org.oooc.kry.global.dto.APIResponse
import org.oooc.kry.global.dto.CheckDTO
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("board")
class BoardController(
    val boardService: BoardService
) {

    @PostMapping("/")
    fun postBoard(
        @RequestBody @Valid boardPostRequestDTO: BoardPostRequestDTO
    ): APIResponse<BoardPostResponseDTO> {
        val board = boardService.createBoard(
            name = boardPostRequestDTO.name,
            seq = boardPostRequestDTO.seq
        )
        val respDTO = BoardPostResponseDTO(
            id = board.id,
            name = board.name,
            seq = board.seq
        )
        return APIResponse(
            data = respDTO
        )
    }

    @GetMapping("/{boardName}")
    fun getBoard(
        @PathVariable boardName: String
    ): APIResponse<BoardGetResponseDTO> {
        val board = boardService.getBoard(
            name = boardName
        )
        val respDTO = BoardGetResponseDTO(
            id = board.id,
            name = board.name,
            seq = board.seq
        )
        return APIResponse(
            data = respDTO
        )
    }

    @PutMapping("/{boardName}")
    fun putBoard(
        @PathVariable boardName: String,
        @RequestBody @Valid boardPutRequestDTO: BoardPutRequestDTO
    ): APIResponse<BoardPutResponseDTO> {
        val board = boardService.modifyBoard(
            name = boardName,
            newName = boardPutRequestDTO.name,
            newSeq = boardPutRequestDTO.seq
        )
        val respDTO = BoardPutResponseDTO(
            id = board.id,
            name = board.name,
            seq = board.seq
        )
        return APIResponse(
            data = respDTO
        )
    }

    @DeleteMapping("/{boardName}")
    fun deleteBoard(
        @PathVariable boardName: String
    ): APIResponse<CheckDTO> {
        boardService.deleteBoard(boardName)
        return APIResponse(
            data = CheckDTO(
                success = true
            )
        )
    }

    @GetMapping("/")
    fun getBoards(): APIResponse<BoardsGetResponseDTO> {
        val boards = boardService.getBoardList()
        val respDTO = BoardsGetResponseDTO(
            boards = boards
        )
        return APIResponse(
            data = respDTO
        )
    }

}