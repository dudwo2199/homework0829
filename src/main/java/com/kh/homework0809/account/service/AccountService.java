package com.kh.homework0809.account.service;

import com.kh.homework0809.account.dto.*;
import com.kh.homework0809.account.entity.AccountEntity;
import com.kh.homework0809.account.repository.AccountRepository;
import com.kh.homework0809.employee.entity.EmpEntity;
import com.kh.homework0809.employee.repository.EmpRepository;
import com.kh.homework0809.exception.ErrorCode;
import com.kh.homework0809.exception.IllegalStateApiException;
import jakarta.persistence.PersistenceException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final EmpRepository empRepository;

    public RespSignUp signUp(ReqSignUp dto) {

        if(repository.existsById(dto.getId())) {
            throw new IllegalStateApiException(ErrorCode.DUPLICATE_ACCOUNT_ID);
        }

        var empEntity = EmpEntity.from(dto);

        try {
            empRepository.registerEmp(empEntity);
            repository.signUp(AccountEntity.from(dto, empEntity));
        } catch (PersistenceException e) {
            throw new IllegalStateApiException(ErrorCode.FAILED_TO_SIGNUP);
        }

        return RespSignUp.from(empEntity);
    }

    public RespSignIn signIn(ReqSignIn dto) {
        var accountEntity = repository.findById(dto.getId());

        if (!accountEntity.getPw().equals(dto.getPw())) {
            throw new IllegalStateApiException(ErrorCode.INVALID_PASSWORD);
        }

        return RespSignIn.from(accountEntity);
    }

    public RespDeleteAccount delete(ReqDeleteAccount dto) {
        var target = repository.findByNo(dto.getTargetNo());

        if (!target.getPw().equals(dto.getPw())) {
            throw new IllegalStateApiException(ErrorCode.INVALID_PASSWORD);
        }

        try {
            target.delete();
        } catch (PersistenceException e) {
            throw new IllegalStateApiException(ErrorCode.FAILED_TO_DELETE_ACCOUNT);
        }
        return RespDeleteAccount.from(target);
    }

    public RespModifyPassWord modify(ReqModifyPassword dto) {
        var target = repository.findByNo(dto.getTargetNo());

        if (!target.getPw().equals(dto.getOriginPw())) {
            throw new IllegalStateApiException(ErrorCode.INVALID_PASSWORD);
        }
        try {
            target.modifyPassword(dto.getNewPw());
        } catch (PersistenceException e) {
            throw new IllegalStateApiException(ErrorCode.FAILED_MODIFY_PASSWORD);
        }

        return RespModifyPassWord.from(target);
    }
}
