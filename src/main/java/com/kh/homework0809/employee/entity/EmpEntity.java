package com.kh.homework0809.employee.entity;

import com.kh.homework0809.account.dto.ReqSignUp;
import com.kh.homework0809.exception.ErrorCode;
import com.kh.homework0809.exception.IllegalStateApiException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name ="EMPLOYEE")
@Getter
@ToString
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eno;

    @Column(nullable = false, length = 128)
    private String name;
    @Column(nullable = false, length = 128)
    private String nick;

    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(insertable = false)
    private LocalDateTime updatedAt = null;
    @Column(insertable = false)
    private LocalDateTime deletedAt = null;

    public static EmpEntity from(ReqSignUp dto){

        if(dto.getId().length() < 2)
            throw new IllegalStateApiException(ErrorCode.SHORT_ID_LENGTH);

        if(dto.getPw().length() < 4)
            throw new IllegalStateApiException(ErrorCode.SHORT_PASSWORD_LENGTH);

        var entity = new EmpEntity();
        entity.name = dto.getName();
        entity.nick = dto.getNick();
        return entity;
    }

    public void modifyNick(String newNick){
        this.nick = newNick;
        this.updatedAt = LocalDateTime.now();
    }

    public void delete() {
        this.deletedAt = LocalDateTime.now();
    }
}
