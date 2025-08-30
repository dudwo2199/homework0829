package com.kh.homework0809.board.dto;

import com.kh.homework0809.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RespDeleteBoard {
    private String msg;
    private ResultData data;

    @Getter
    @Setter
    @Builder
    public static class ResultData {
        private int bno;
    }

    public static RespDeleteBoard from(BoardEntity entity) {
        return RespDeleteBoard.builder()
                .msg("게시글 삭제 성공")
                .data(ResultData.builder()
                        .bno(entity.getBno())
                        .build())
                .build();
    }
}
