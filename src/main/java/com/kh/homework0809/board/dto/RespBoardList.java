package com.kh.homework0809.board.dto;

import com.kh.homework0809.board.entity.BoardEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RespBoardList {
    private String msg;
    private List<ResultData> data;

    @Getter
    @Setter
    @Builder
    public static class ResultData {
        private int boardNo;
        private String title;
        private String content;
        private int view;
        private String writerName;
        private String createdAt;

        public static ResultData from(BoardEntity entity) {
            return ResultData.builder()
                    .boardNo(entity.getBno())
                    .title(entity.getTitle())
                    .content(entity.getContent())
                    .view(entity.getView())
                    .writerName(entity.getWriter().getNick())
                    .createdAt(entity.getCreatedAt().toString())
                    .build();
        }
    }

    public static RespBoardList from(List<BoardEntity> entity) {
        return RespBoardList.builder()
                .msg("게시글 상세 조회 성공")
                .data(entity.stream()
                        .map(ResultData::from)
                        .toList())
                .build();
    }
}
