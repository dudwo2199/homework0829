package com.kh.homework0809.account.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "ACCOUNT")
@Getter
public class AccountEntity {
    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "EMP_NO")
    private int no;

    @Column(nullable = false, unique = true)
    private String id;
    @Column(nullable = false)
    private String pw;
}
