package org.oooc.kry.board.controller

import org.oooc.kry.board.service.BoardService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class BoardController(val boardService: BoardService) {

    // 게시판 생성
    @PostMapping("/")
    fun postBoard() {

    }

    // 게시판 조회
    @GetMapping("/{boardName}")
    fun getBoard(@PathVariable("boardName") boardName: String) {

    }

    // 게시판 수정
    @PutMapping("/{boardName}")
    fun putBoard() {

    }

    // 게시판 삭제
    @DeleteMapping("/{boardName}")
    fun deleteBoard() {

    }

    // 게시판 목록 조회
    @GetMapping("/")
    fun getBoards() {
        return boardService.getBoards()
    }

    // 게시글 생성
    @PostMapping("/{boardName}/article")
    fun postArticle() {

    }

    // 게시글 조회
    @GetMapping("/{boardName}/article/{articleNo}")
    fun getArticle() {

    }

    // 게시글 수정
    @PutMapping("/{boardName}/article/{articleNo}")
    fun putArticle() {

    }

    // 게시글 삭제
    @DeleteMapping("/{boardName}/article/{articleNo}")
    fun deleteArticle() {

    }

    // 게시글 목록 조회
    @GetMapping("/{boardName}/article")
    fun getArticles() {

    }

    // 댓글 생성
    @PostMapping("/{boardName}/article/{articleNo}/comment")
    fun postComment() {

    }

    // 댓글 조회
    @GetMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun getComment() {

    }

    // 댓글 삭제
    @DeleteMapping("/{boardName}/article/{articleNo}/comment/{commentNo}")
    fun deleteComment() {

    }

    // 댓글 목록 조회
    @GetMapping("/{boardName}/article/{articleNo}/comment")
    fun getComments() {

    }
}