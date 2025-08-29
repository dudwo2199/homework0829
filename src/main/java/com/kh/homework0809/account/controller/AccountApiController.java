package com.kh.homework0809.account.controller;

import com.kh.homework0809.account.dto.*;
import com.kh.homework0809.account.service.AccountService;
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


        return ResponseEntity.ok(null);
    }

    @PostMapping("/sign-in")
    public ResponseEntity<RespSignIn> signIn(@RequestBody ReqSignIn dto) {


        return ResponseEntity.ok(null);
    }

    @PostMapping("/sign-out")
    public ResponseEntity<RespSignOut> signOut(@RequestBody ReqSignOut dto) {

        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{no}")
    public ResponseEntity<Void> deleteAccount(@PathVariable int no) {

        return ResponseEntity.ok().build();
    }
}
