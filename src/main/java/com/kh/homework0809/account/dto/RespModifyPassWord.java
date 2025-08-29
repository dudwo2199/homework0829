package com.kh.homework0809.account.dto;

import com.kh.homework0809.account.entity.AccountEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RespModifyPassWord {
    private String msg;
    private ResultData data;

    @Getter
    @Setter
    @Builder
    static class ResultData {
        private int no;
    }

    public static RespModifyPassWord from(AccountEntity target) {
        return RespModifyPassWord.builder()
                .msg("비밀번호 변경 성공")
                .data(ResultData.builder()
                        .no(target.getEno().getEno())
                        .build())
                .build();
    }
}
