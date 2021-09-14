package org.oooc.kry.board.web.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.junit.jupiter.api.Test

import org.oooc.kry.board.domain.dto.BoardPostRequestDTO
import org.oooc.kry.global.enum.ErrorCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
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
@AutoConfigureMockMvc
internal class BoardControllerTest(
    @Autowired val boardController: BoardController,
    @Autowired val mockMvc: MockMvc
) {
    val boardService = boardController.boardService

    fun asJsonString(obj: Any): String {
        try {
            val mapper = ObjectMapper()
            val jsonContent = mapper.writeValueAsString(obj)
            return jsonContent
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    fun asMap(s: String): MutableMap<Any, Any> {
        try {
            val mapper = ObjectMapper()
            val map: MutableMap<Any, Any> = mapper.readValue<MutableMap<Any, Any>>(s)
            return map
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

    @Test
    @Transactional
    @Commit
    fun postBoard() {
        val dto = BoardPostRequestDTO(
            name = "board1",
            seq = 100
        )

        /*
        val mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                //.andDo(MockMvcResultHandlers.print())
                .andReturn()
        val result = mvcResult.response.contentAsString
        val mapResult = asMap(result)

        // TODO: check if "id" key in json string exists
        Assertions.assertThat(mapResult["name"]).isEqualTo(dto.name)
        Assertions.assertThat(mapResult["seq"]).isEqualTo(dto.seq)
        */

        mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.data.id").exists())
                .andExpect(jsonPath("$.data.name").value(dto.name))
                .andExpect(jsonPath("$.data.seq").value(dto.seq))
    }

    @Test
    @Transactional
    fun postBoard_빈_게시판_이름() {
        val dto = BoardPostRequestDTO(
                name = "",
                seq = 100
        )

        mockMvc.perform(MockMvcRequestBuilders.post("/board/")
                .content(asJsonString(dto))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.error.code").value(ErrorCode.METHOD_ARGUMENT_NOT_VALID.toString()))
    }

    @Test
    fun getBoard() {
    }

    @Test
    fun putBoard() {
    }

    @Test
    fun deleteBoard() {
    }

    @Test
    fun getBoards() {
    }
}