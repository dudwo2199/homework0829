package com.kh.homework0809.employee.dto;

import com.kh.homework0809.employee.entity.EmpEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RespMyPage {
    private int eno;
    private String name;
    private String nick;

    public static RespMyPage from(EmpEntity entity) {
        RespMyPage resp = new RespMyPage();
        resp.setEno(entity.getEno());
        resp.setName(entity.getName());
        resp.setNick(entity.getNick());
        return resp;
    }
}
