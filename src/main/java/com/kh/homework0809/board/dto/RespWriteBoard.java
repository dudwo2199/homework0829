package com.kh.homework0809.board.dto;

import com.kh.homework0809.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RespWriteBoard {
    private String msg;
    private ResultData data;

    @Getter
    @Setter
    @Builder
    public static class ResultData {
        private int bno;
    }

    public static RespWriteBoard from(BoardEntity entity) {
        return RespWriteBoard.builder()
                .msg("게시글 작성 성공")
                .data(ResultData.builder()
                        .bno(entity.getBno())
                        .build())
                .build();
    }
}
