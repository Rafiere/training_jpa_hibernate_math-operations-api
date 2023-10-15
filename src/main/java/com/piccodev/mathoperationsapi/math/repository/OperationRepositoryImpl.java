package com.piccodev.mathoperationsapi.math.repository;

import com.piccodev.mathoperationsapi.math.domain.Operation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class OperationRepositoryImpl implements OperationRepository {

    @PersistenceContext(name = "Operations-PU")
    private EntityManager entityManager;

    @Override
    public void save(final Operation operation) {
        entityManager.persist(operation);
    }
}
