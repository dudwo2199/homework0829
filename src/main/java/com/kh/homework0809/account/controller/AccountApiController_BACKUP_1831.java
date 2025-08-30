package com.kh.homework0809.account.controller;

import com.kh.homework0809.account.dto.*;
import com.kh.homework0809.account.service.AccountService;
import com.kh.homework0809.common.Authenticator;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountApiController {
    private final AccountService service;

    @PostMapping("/sign-up")
    public ResponseEntity<RespSignUp> signUp(@RequestBody ReqSignUp dto) {
        RespSignUp result = service.signUp(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<RespSignIn> signIn(@RequestBody ReqSignIn dto, HttpSession session) {
        var result = service.signIn(dto);

        var auth = Authenticator.builder()
                .no(result.getData().getNo())
                .build();

        session.setAttribute("Authenticator", auth);

        return ResponseEntity.ok(result);
    }

    @DeleteMapping
    public ResponseEntity<RespDeleteAccount> deleteAccount(@RequestBody ReqDeleteAccount dto, HttpSession session) {
        var auth = (Authenticator) session.getAttribute("Authenticator");

        dto.setTargetNo(auth.getNo());
        var result = service.delete(dto);

        session.invalidate();

        return ResponseEntity.ok(result);
    }

    @PutMapping
<<<<<<< HEAD
    public ResponseEntity<RespModifyPassWord> modifyAccount(@RequestBody ReqModifyPassword dto, HttpSession session) {
        var auth = (RespSignIn) session.getAttribute("ACCOUNT");
        dto.setTargetNo(auth.getData().getNo());
=======
    public ResponseEntity<RespModifyPassWord> updateAccount(@RequestBody ReqModifyPassword dto, HttpSession session) {
        var auth = (Authenticator) session.getAttribute("Authenticator");
        dto.setTargetNo(auth.getNo());
>>>>>>> 41a59e4 (숙제)
        var result = service.modify(dto);

        return ResponseEntity.ok(result);
    }
}
