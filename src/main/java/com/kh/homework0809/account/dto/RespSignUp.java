package com.kh.homework0809.account.dto;

import com.kh.homework0809.employee.entity.EmpEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RespSignUp {
    private String msg;
    private ResultData data;

    @Builder
    @Getter
    static class ResultData {
        private int no;
    }

    public static RespSignUp from(EmpEntity empEntity) {
        return RespSignUp.builder()
                .msg("회원가입 성공")
                .data(ResultData.builder()
                        .no(empEntity.getEno())
                        .build())
                .build();
    }
}