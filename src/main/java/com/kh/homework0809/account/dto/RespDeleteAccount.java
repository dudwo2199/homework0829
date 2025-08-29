package com.kh.homework0809.account.dto;

import com.kh.homework0809.account.entity.AccountEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class RespDeleteAccount {
    private String msg;
    private ResultData data;

    @Getter
    @Setter
    @Builder
    static class ResultData{
        private int delNo;
        private LocalDateTime deletedAt;
    }

    public static RespDeleteAccount from(AccountEntity entity){
        return RespDeleteAccount.builder()
                .msg("계정 삭제 성공")
                .data(ResultData.builder()
                        .delNo(entity.getEno().getEno())
                        .deletedAt(entity.getDeletedAt())
                        .build())
                .build();
    }
}
