package com.kh.homework0809.employee.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name ="EMPLOYEE")
@Getter
public class EmpEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int eno;

    @Column(nullable = false, length = 128)
    private String name;
    @Column(nullable = false, length = 128)
    private String nick;

    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt = null;
    private LocalDateTime deletedAt = null;
}
