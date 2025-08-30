package com.kh.homework0809.board.dto;

import com.kh.homework0809.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RespModifyBoard {
    private String msg;
    private ResultData data;

    @Getter
    @Setter
    @Builder
    public static class ResultData {
        private int bno;
    }

    public static RespModifyBoard from(BoardEntity entity) {
        return RespModifyBoard.builder()
                .msg("게시글 수정 성공")
                .data(ResultData.builder()
                        .bno(entity.getBno())
                        .build())
                .build();
    }
}
