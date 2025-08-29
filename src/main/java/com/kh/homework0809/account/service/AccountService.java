package com.kh.homework0809.account.service;

import com.kh.homework0809.account.repository.AccountRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
}
