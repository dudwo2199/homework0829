package com.kh.homework0809.board.dto;

import com.kh.homework0809.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RespBoard {
    private String msg;
    private ResultData data;

    @Getter
    @Setter
    @Builder
    public static class ResultData {
        private int boardNo;
        private String title;
        private String content;
        private String writer;
        private String createdAt;
        private int view;
    }

    public static RespBoard from(BoardEntity entity) {
        return RespBoard.builder()
                .msg("게시글 상세 조회 성공")
                .data(ResultData.builder()
                        .boardNo(entity.getBno())
                        .title(entity.getTitle())
                        .content(entity.getContent())
                        .writer(entity.getWriter().getNick())
                        .createdAt(entity.getCreatedAt().toString())
                        .view(entity.getView())
                        .build())
                .build();
    }
}
