package com.piccodev.mathoperationsapi.math.controller.request;

import com.piccodev.mathoperationsapi.math.domain.enums.OperationType;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record CreateOperationRequest(@NotNull BigDecimal firstNumber, @NotNull BigDecimal secondNumber, @NotNull OperationType operationType) {

}
