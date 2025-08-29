package com.kh.homework0809.employee.repository;

import com.kh.homework0809.employee.entity.EmpEntity;
import com.kh.homework0809.exception.ErrorCode;
import com.kh.homework0809.exception.IllegalStateApiException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class EmpRepository {
    private final EntityManager em;


    public void registerEmp(EmpEntity entity) throws PersistenceException {
        em.persist(entity);
    }
}
