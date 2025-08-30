package com.kh.homework0809.employee.service;

import com.kh.homework0809.employee.dto.ReqModifyNick;
import com.kh.homework0809.employee.dto.RespModifyNick;
import com.kh.homework0809.employee.dto.RespMyPage;
import com.kh.homework0809.employee.repository.EmpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class EmpService {
    private final EmpRepository repository;

    public RespMyPage myPage(int no) {
        var result = repository.findByNo(no);

        return RespMyPage.from(result);
    }

    public RespModifyNick modifyNick(ReqModifyNick dto) {
        var target = repository.findByNo(dto.getTargetNo());

        target.modifyNick(dto.getNewNick());

        return RespModifyNick.from(target);
    }
}
