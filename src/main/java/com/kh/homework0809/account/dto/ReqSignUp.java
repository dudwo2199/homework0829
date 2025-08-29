package com.kh.homework0809.account.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ReqSignUp {
    private String id;
    private String pw;
    private String name;
    private String nick;
}
