package com.kh.homework0809.board.controller;

import com.kh.homework0809.board.dto.*;
import com.kh.homework0809.board.service.BoardService;
import com.kh.homework0809.common.Authenticator;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService service;

    @GetMapping
    public ResponseEntity<RespBoardList> lookUp() {
        var result = service.lookUp();

        return ResponseEntity
                .ok(result);
    }

    @GetMapping("/mine")
    public ResponseEntity<RespBoardList> lookUpMine(HttpSession session) {

        var auth = (Authenticator) session.getAttribute("Authenticator");

        var result = service.lookUpMine(auth.getNo());

        return ResponseEntity
                .ok(result);
    }

    @GetMapping("/{bno}")
    public ResponseEntity<RespBoard> lookAt(@PathVariable int bno) {

        var result = service.lookAt(bno);

        return ResponseEntity
                .ok(result);
    }

    @PostMapping
    public ResponseEntity<RespWriteBoard> writeBoard(@RequestBody ReqWriteBoard dto, HttpSession session) {
        var auth = (Authenticator) session.getAttribute("Authenticator");

        if(auth == null){
            return ResponseEntity
                    .badRequest()
                    .body(RespWriteBoard.builder()
                            .msg("로그인이 필요합니다.")
                            .data(null)
                            .build());
        }

        dto.setWriterNo(auth.getNo());

        var result = service.writeBoard(dto);

        return ResponseEntity
                .ok(result);
    }

    @PutMapping
    public ResponseEntity<RespModifyBoard> modifyBoard(@RequestBody ReqModifyBoard dto, HttpSession session) {
        System.out.println("dto = " + dto);
        var auth = (Authenticator) session.getAttribute("Authenticator");

        var result = service.modifyBoard(dto, auth);

        return ResponseEntity
                .ok(result);
    }

    @DeleteMapping("/{bno}")
    public ResponseEntity<RespDeleteBoard> deleteBoard(@PathVariable int bno, HttpSession session) {
        var auth = (Authenticator) session.getAttribute("Authenticator");

        var result = service.deleteBoard(bno, auth);

        return ResponseEntity
                .ok(result);
    }
}
