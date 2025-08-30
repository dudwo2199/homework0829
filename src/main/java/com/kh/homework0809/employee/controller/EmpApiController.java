package com.kh.homework0809.employee.controller;

import com.kh.homework0809.account.dto.RespSignIn;
import com.kh.homework0809.common.Authenticator;
import com.kh.homework0809.employee.dto.ReqModifyNick;
import com.kh.homework0809.employee.dto.RespModifyNick;
import com.kh.homework0809.employee.dto.RespMyPage;
import com.kh.homework0809.employee.service.EmpService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/emp")
public class EmpApiController {
    private final EmpService service;

    @GetMapping("/my-page")
    public ResponseEntity<RespMyPage> myPage(HttpSession session) {
        var auth = (Authenticator) session.getAttribute("Authenticator");

        var result = service.myPage(auth.getNo());

        return ResponseEntity
                .ok(result);
    }

    @PutMapping
    public ResponseEntity<RespModifyNick> modifyNick(@RequestBody ReqModifyNick dto, HttpSession session) {
        var auth = (Authenticator) session.getAttribute("Authenticator");

        dto.setTargetNo(auth.getNo());

        var result = service.modifyNick(dto);

        return ResponseEntity
                .ok(result);
    }
}
