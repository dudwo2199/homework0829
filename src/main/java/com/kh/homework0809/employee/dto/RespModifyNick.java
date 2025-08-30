package com.kh.homework0809.employee.dto;

import com.kh.homework0809.employee.entity.EmpEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RespModifyNick {
    private String msg;
    private ResultData data;

    @Getter
    @Setter
    @Builder
    public static class ResultData {
        private int eno;
        private String nick;
    }

    public static RespModifyNick from(EmpEntity target) {
        return RespModifyNick.builder()
                .msg("닉네임 변경 성공")
                .data(ResultData.builder()
                        .eno(target.getEno())
                        .nick(target.getNick())
                        .build())
                .build();
    }
}
