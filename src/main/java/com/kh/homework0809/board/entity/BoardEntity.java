package com.kh.homework0809.board.entity;

import com.kh.homework0809.board.dto.ReqModifyBoard;
import com.kh.homework0809.board.dto.ReqWriteBoard;
import com.kh.homework0809.employee.entity.EmpEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "BOARD")
@Getter
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bno;

    @Column(nullable = false, length = 128)
    private String title;
    @Column(nullable = false, length = 2048)
    private String content;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer", nullable = false)
    private EmpEntity writer;
    @Column(nullable = false)
    private int view = 0;

    private LocalDateTime createdAt = LocalDateTime.now();
    @Column(insertable = false)
    private LocalDateTime updatedAt = null;
    @Column(insertable = false)
    private LocalDateTime deletedAt = null;

    public void increaseView() {
        this.view += 1;
    }

    public void modifyBoard(ReqModifyBoard dto) {
        this.title = dto.getNewTitle();
        this.content = dto.getNewContent();
        this.updatedAt = LocalDateTime.now();
    }

    public void delete(BoardEntity entity) {
        this.deletedAt = LocalDateTime.now();
    }

    public static BoardEntity from(ReqWriteBoard dto, EmpEntity empEntity) {
        var entity = new BoardEntity();
        entity.title = dto.getTitle();
        entity.content = dto.getContent();
        entity.writer = empEntity;
        return entity;
    }
}
