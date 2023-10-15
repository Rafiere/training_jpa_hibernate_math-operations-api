package com.piccodev.mathoperationsapi.math.controller.response;

import com.piccodev.mathoperationsapi.math.domain.Operation;
import com.piccodev.mathoperationsapi.math.domain.enums.OperationType;

import java.math.BigDecimal;

public record OperationResponse(BigDecimal firstNumber, BigDecimal secondNumber, BigDecimal result, OperationType operationType) {
    public static OperationResponse from(Operation operation) {

        return new OperationResponse(operation.getFirstNumber(), operation.getSecondNumber(), operation.getResult(), operation.getOperation());
    }
}
