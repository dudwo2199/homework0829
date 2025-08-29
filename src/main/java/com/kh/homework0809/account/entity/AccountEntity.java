package com.kh.homework0809.account.entity;

import com.kh.homework0809.account.dto.ReqSignUp;
import com.kh.homework0809.employee.entity.EmpEntity;
import com.kh.homework0809.exception.ErrorCode;
import com.kh.homework0809.exception.IllegalStateApiException;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Table(name = "ACCOUNT")
@Getter
@ToString
public class AccountEntity {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eno", nullable = false)
    private EmpEntity eno;

    @Column(nullable = false, unique = true, length = 128)
    private String id;
    @Column(nullable = false, length = 128)
    private String pw;

    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(insertable = false)
    private LocalDateTime updatedAt = null;
    @Column(insertable = false)
    private LocalDateTime deletedAt = null;

    public static AccountEntity from(ReqSignUp dto, EmpEntity empEntity) {
        var entity = new AccountEntity();
        entity.eno = empEntity;
        entity.id = dto.getId();
        entity.pw = dto.getPw();
        return entity;
    }

    public void delete(){
        this.deletedAt = LocalDateTime.now();
    }

    public void modifyPassword(String newPw){
        if(newPw.length() < 4){
            throw new IllegalStateApiException(ErrorCode.SHORT_PASSWORD_LENGTH);
        }
        this.pw = newPw;
        this.updatedAt = LocalDateTime.now();
    }
}
