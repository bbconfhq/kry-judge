package org.oooc.kry.board.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.oooc.kry.board.config.AutoConfigureMockMvcUtf8

import org.oooc.kry.board.domain.dto.BoardPostRequestDTO
import org.oooc.kry.board.domain.dto.BoardPutRequestDTO
import org.oooc.kry.global.enum.ErrorCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.annotation.Commit
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
import org.springframework.transaction.annotation.Transactional
import java.lang.RuntimeException

@SpringBootTest
@AutoConfigureMockMvcUtf8
@Transactional
internal class BoardControllerTest(
    @Autowired val boardController: BoardController,
    @Autowired val mockMvc: MockMvc
) {
    val boardService = boardController.boardService
    val boardRepository = boardService.boardRepository

    fun asJsonString(obj: Any): String {
        try {
            val mapper = ObjectMapper()
            val jsonContent = mapper.writeValueAsString(obj)
            return jsonContent
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    @Test
    fun postBoard() {
        val dto = BoardPostRequestDTO(
                name = "board1",
                seq = 101
        )

        mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.name").value(dto.name))
                .andExpect(jsonPath("$.data.seq").value(dto.seq))
    }

    @Test
    fun postBoard_empty_board_name() {
        val dto = BoardPostRequestDTO(
                name = "",
                seq = 101
        )

        mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value(ErrorCode.METHOD_ARGUMENT_NOT_VALID.toString()))
    }

    @Test
    fun postBoard_dup_name() {
        val dto1 = BoardPostRequestDTO(
                name = "board1",
                seq = 101
        )
        val dto2 = BoardPostRequestDTO(
                name = "board1",
                seq = 102
        )

        mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.name").value(dto1.name))
                .andExpect(jsonPath("$.data.seq").value(dto1.seq))

        mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value(ErrorCode.DATA_INTEGRITY_VIOLATION.toString()))
    }

    @Test
    fun postBoard_dup_seq() {
        val dto1 = BoardPostRequestDTO(
                name = "board1",
                seq = 101
        )
        val dto2 = BoardPostRequestDTO(
                name = "board2",
                seq = 101
        )

        mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto1))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.name").value(dto1.name))
                .andExpect(jsonPath("$.data.seq").value(dto1.seq))

        mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value(ErrorCode.DATA_INTEGRITY_VIOLATION.toString()))
    }

    @Test
    fun getBoard() {
        boardService.createBoard("board1", 101)
        boardService.createBoard("board2", 102)
        mockMvc.perform(MockMvcRequestBuilders.get("/board/board1"))
                .andExpect(jsonPath("$.data.name").value("board1"))
                .andExpect(jsonPath("$.data.seq").value(101))
        mockMvc.perform(MockMvcRequestBuilders.get("/board/board2"))
                .andExpect(jsonPath("$.data.name").value("board2"))
                .andExpect(jsonPath("$.data.seq").value(102))
    }

    @Test
    fun getBoard_invalid_board_name() {
        boardService.createBoard("board1", 101)
        boardService.createBoard("board2", 102)
        mockMvc.perform(MockMvcRequestBuilders.get("/board/board1"))
                .andExpect(jsonPath("$.data.name").value("board1"))
                .andExpect(jsonPath("$.data.seq").value(101))
        mockMvc.perform(MockMvcRequestBuilders.get("/board/board2"))
                .andExpect(jsonPath("$.data.name").value("board2"))
                .andExpect(jsonPath("$.data.seq").value(102))
        mockMvc.perform(MockMvcRequestBuilders.get("/board/board3"))
                .andExpect(jsonPath("$.error.code").value(ErrorCode.BOARD_NOT_FOUND.toString()))
    }

    @Test
    fun putBoard() {
        val dto1 = BoardPutRequestDTO(
                name = "board1",
                seq = 110
        )
        val dto2 = BoardPutRequestDTO(
                name = "board20",
                seq = 102
        )
        val dto3 = BoardPutRequestDTO(
                name = "board30",
                seq = 103
        )

        boardService.createBoard("board1", 101)
        boardService.createBoard("board2", 102)
        boardService.createBoard("board3", 103)

        mockMvc.perform(MockMvcRequestBuilders.put("/board/board1")
                .content(asJsonString(dto1))
                .contentType(MediaType.APPLICATION_JSON))
        Assertions.assertEquals(boardService.getBoard("board1").seq, 110)

        mockMvc.perform(MockMvcRequestBuilders.put("/board/board2")
                .content(asJsonString(dto2))
                .contentType(MediaType.APPLICATION_JSON))
        Assertions.assertEquals(boardService.getBoard("board20").seq, 102)

        mockMvc.perform(MockMvcRequestBuilders.put("/board/board3")
                .content(asJsonString(dto3))
                .contentType(MediaType.APPLICATION_JSON))
        Assertions.assertEquals(boardService.getBoard("board30").seq, 103)
    }

    @Test
    @Transactional
    fun putBoard_dup() {
        val dto2 = BoardPutRequestDTO(
                name = "board2",
                seq = 101
        )
        val dto3 = BoardPutRequestDTO(
                name = "board1",
                seq = 103
        )

        boardService.createBoard("board1", 101)
        boardService.createBoard("board2", 102)
        boardService.createBoard("board3", 103)

        mockMvc.perform(MockMvcRequestBuilders.put("/board/board2")
                .content(asJsonString(dto2))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value(ErrorCode.DATA_INTEGRITY_VIOLATION.toString()))

        mockMvc.perform(MockMvcRequestBuilders.put("/board/board3")
                .content(asJsonString(dto3))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value(ErrorCode.DATA_INTEGRITY_VIOLATION.toString()))
    }

    @Test
    fun deleteBoard() {
        boardService.createBoard("board1", 101)
        boardService.createBoard("board2", 102)
        boardService.createBoard("board3", 103)

        mockMvc.perform(MockMvcRequestBuilders.delete("/board/board2"))

        Assertions.assertEquals(boardService.getBoardList().size, 2)
    }

    @Test
    fun getBoards() {
    }
}