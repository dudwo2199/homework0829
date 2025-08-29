package com.kh.homework0809.account.dto;

import com.kh.homework0809.account.entity.AccountEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RespSignIn {
    private String msg;
    private ResultData data;

    @Getter
    @Setter
    @Builder
    public static class ResultData {
        private int no;
        private String nick;
        private String name;
    }

    public static RespSignIn from(AccountEntity entity) {
        return RespSignIn.builder()
                .msg("로그인 성공")
                .data(ResultData.builder()
                        .no(entity.getEno().getEno())
                        .nick(entity.getEno().getNick())
                        .name(entity.getEno().getName())
                        .build())
                .build();
    }
}
