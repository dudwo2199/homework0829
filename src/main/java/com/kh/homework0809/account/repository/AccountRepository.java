package com.kh.homework0809.account.repository;

import com.kh.homework0809.account.dto.ReqSignIn;
import com.kh.homework0809.account.entity.AccountEntity;
import com.kh.homework0809.exception.ErrorCode;
import com.kh.homework0809.exception.IllegalStateApiException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountRepository {
    private final EntityManager em;

    public void signUp(AccountEntity entity) throws PersistenceException {
        em.persist(entity);
    }

    public AccountEntity findByNo(int no) {
        return em.find(AccountEntity.class, no);
    }

    public AccountEntity findById(String id) {
        String jpql = "select a from AccountEntity a where a.id = :id";
        try {
            return em.createQuery(jpql, AccountEntity.class)
                    .setParameter("id", id)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new IllegalStateApiException(ErrorCode.NOT_FOUND_ACCOUNT);
        }
    }

    public boolean existsById(String id) {
        String jpql = "select count(a) from AccountEntity a where a.id = :id";
        Long count = em.createQuery(jpql, Long.class)
                .setParameter("id", id)
                .getSingleResult();
        return count > 0;
    }
}
