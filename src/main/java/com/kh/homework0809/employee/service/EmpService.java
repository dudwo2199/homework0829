package com.kh.homework0809.employee.service;

import com.kh.homework0809.employee.repository.EmpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepository repository;
}
