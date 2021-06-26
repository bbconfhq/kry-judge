package org.oooc.kry.board.controller

import org.oooc.kry.board.dto.BoardCreateRequestDto
import org.oooc.kry.board.service.BoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class BoardController(val boardService: BoardService) {

    // CREATE BOARD
    @PostMapping("/")
    fun postBoard(@RequestBody boardCreateRequestDto: BoardCreateRequestDto): String {
        boardService.createBoard(boardCreateRequestDto)
        return "a"
    }

    // GET BOARD
    @GetMapping("/{boardName}")
    fun getBoard(@PathVariable("boardName") boardName: String) {

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

    // CREATE ARTICLE
    @PostMapping("/{boardName}/article")
    fun postArticle() {

    }

    // GET ARTICLE
    @GetMapping("/{boardName}/article/{articleNo}")
    fun getArticle() {

    }

    // MODIFY ARTICLE
    @PutMapping("/{boardName}/article/{articleNo}")
    fun putArticle() {

    }

    // DELETE ARTICLE
    @DeleteMapping("/{boardName}/article/{articleNo}")
    fun deleteArticle() {

    }

    // GET LIST OF ARTICLES
    @GetMapping("/{boardName}/article")
    fun getArticles() {

    }

    // CREATE COMMENT
    @PostMapping("/{boardName}/article/{articleNo}/comment")
    fun postComment() {

    }

    // GET COMMENT
    @GetMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun getComment() {

    }

    // DELETE COMMENT
    @DeleteMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun deleteComment() {

    }

    // GET LIST OF COMMENTS
    @GetMapping("/{boardName}/article/{articleNo}/comment")
    fun getComments() {

    }
}
