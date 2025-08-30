package com.kh.homework0809.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqModifyNick {
    private int targetNo;
    private String newNick;
}
