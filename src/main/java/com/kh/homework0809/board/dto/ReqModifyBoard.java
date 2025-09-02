package com.kh.homework0809.board.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReqModifyBoard {
    private int targetNo;
    private String newTitle;
    private String newContent;
}
