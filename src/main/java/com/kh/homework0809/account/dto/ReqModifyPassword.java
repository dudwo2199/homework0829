package com.kh.homework0809.account.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqModifyPassword {
    private int targetNo;
    private String originPw;
    private String newPw;
}
