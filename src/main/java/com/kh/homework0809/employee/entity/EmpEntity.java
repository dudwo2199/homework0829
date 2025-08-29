package com.kh.homework0809.employee.entity;

import com.kh.homework0809.account.dto.ReqSignUp;
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
        var entity = new EmpEntity();
        entity.name = dto.getName();
        entity.nick = dto.getNick();
        return entity;
    }
}
