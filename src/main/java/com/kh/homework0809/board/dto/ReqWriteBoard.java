package com.kh.homework0809.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqWriteBoard {
    private int writerNo;
    private String title;
    private String content;
}
