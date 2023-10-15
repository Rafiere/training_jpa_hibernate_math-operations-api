package com.piccodev.mathoperationsapi.math.repository;

import com.piccodev.mathoperationsapi.math.domain.Operation;

public interface OperationRepository {

    void save(Operation operation);
}
