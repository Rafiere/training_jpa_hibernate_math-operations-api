package com.piccodev.mathoperationsapi.math.domain;

import com.piccodev.mathoperationsapi.math.domain.enums.OperationType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.UUID;

import static org.w3c.dom.events.MutationEvent.ADDITION;

@Getter
@Entity
@NoArgsConstructor
public class Operation {

    @Id
    private String id;

    private BigDecimal firstNumber;
    private BigDecimal secondNumber;
    private BigDecimal result;
    @Enumerated(EnumType.STRING)
    private OperationType operation;

    private Operation(final String id,
                      final BigDecimal firstNumber,
                      final BigDecimal secondNumber,
                      final BigDecimal result,
                      final OperationType operation) {

        this.id = id;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
        this.result = result;
        this.operation = operation;

        this.validate();
    }

    private void validate() {

        if(firstNumber == null || secondNumber == null || operation == null) {
            throw new IllegalArgumentException("Operation not valid");
        }

        verifyIfSecondNumberIsZero();
    }

    public static Operation of(final BigDecimal firstNumber,
                               final BigDecimal secondNumber,
                               final BigDecimal result,
                               final OperationType operation) {

        return new Operation(UUID.randomUUID().toString(), firstNumber, secondNumber, result, operation);
    }

    public void setResult(BigDecimal result) {

        this.result = result;
    }

    public BigDecimal calculateResult() {

        return switch (operation) {
            case SUM -> firstNumber.add(secondNumber);
            case SUBTRACT -> firstNumber.subtract(secondNumber);
            case MULTIPLY -> firstNumber.multiply(secondNumber);
            case DIVIDE -> {
                verifyIfSecondNumberIsZero();
                yield firstNumber.divide(secondNumber, RoundingMode.HALF_EVEN);
            }
        };
    }

    private void verifyIfSecondNumberIsZero() {
        if (secondNumber.equals(BigDecimal.ZERO)) {
            throw new ArithmeticException("Division by zero");
        }
    }
}
