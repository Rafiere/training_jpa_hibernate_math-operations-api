package com.piccodev.mathoperationsapi.math.controller;

import com.piccodev.mathoperationsapi.math.controller.request.CreateOperationRequest;
import com.piccodev.mathoperationsapi.math.controller.response.OperationResponse;
import com.piccodev.mathoperationsapi.math.domain.Operation;
import com.piccodev.mathoperationsapi.math.service.CreateOperationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/operations")
public class OperationController {

    private final CreateOperationService createOperationService;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OperationResponse> execute(@Valid @RequestBody final CreateOperationRequest operation) {

        final Operation createdOperation = createOperationService.execute(operation);

        var response = OperationResponse.from(createdOperation);

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
