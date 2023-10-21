package com.piccodev.mathoperationsapi.math.service;

import com.piccodev.mathoperationsapi.math.controller.request.CreateOperationRequest;
import com.piccodev.mathoperationsapi.math.domain.Operation;
import com.piccodev.mathoperationsapi.math.repository.OperationRepositoryImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class CreateOperationService {

    private final OperationRepositoryImpl operationRepository;

    public Operation execute(final CreateOperationRequest request) {

        final Operation operation = Operation.of(request.firstNumber(), request.secondNumber(), BigDecimal.ZERO, request.operationType());

        final BigDecimal result = operation.calculateResult();

        operation.setResult(result);

        operationRepository.save(operation);

        return operation;
    }
}
