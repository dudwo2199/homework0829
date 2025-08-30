package com.kh.homework0809.board.repository;

import com.kh.homework0809.board.entity.BoardEntity;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardRepository {
    private final EntityManager em;

    public List<BoardEntity> lookUp() {
        String jpql = "SELECT b FROM BoardEntity b JOIN FETCH b.writer WHERE b.deletedAt IS NULL ORDER BY b.bno DESC";
        return em.createQuery(jpql, BoardEntity.class)
                .getResultList();
    }

    public List<BoardEntity> lookUpMine(int no) {
        String jpql = "SELECT b FROM BoardEntity b JOIN FETCH b.writer WHERE b.deletedAt IS NULL AND b.writer.eno = :no ORDER BY b.bno DESC";
        return em.createQuery(jpql, BoardEntity.class)
                .setParameter("no", no)
                .getResultList();
    }

    public BoardEntity lookAt(int bno) {
        String jpql = "SELECT b FROM BoardEntity b JOIN FETCH b.writer WHERE b.deletedAt IS NULL AND b.bno = :bno";
        return em.createQuery(jpql, BoardEntity.class)
                .setParameter("bno", bno)
                .getSingleResult();
    }

    public void write(BoardEntity entity) {
        em.persist(entity);
    }
}
