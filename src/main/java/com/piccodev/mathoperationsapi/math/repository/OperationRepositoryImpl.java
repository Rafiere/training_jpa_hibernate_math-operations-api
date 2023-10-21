package com.piccodev.mathoperationsapi.math.repository;

import com.piccodev.mathoperationsapi.math.domain.Operation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class OperationRepositoryImpl implements OperationRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(final Operation operation) {

        entityManager.persist(operation);
    }
}
