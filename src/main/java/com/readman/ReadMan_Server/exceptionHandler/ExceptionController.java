package com.readman.ReadMan_Server.exceptionHandler;

import com.readman.ReadMan_Server.model.ExceptionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<ExceptionModel> HandleExceptionResolver(Exception ex){
        var exceptionModel = ExceptionModel.builder()
                .status(Boolean.FALSE)
                .errorHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .errorMessage(ex.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionModel);
    }

}
