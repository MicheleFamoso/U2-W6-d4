package it.Epicode.U2_W6_d4.exception;


import it.Epicode.U2_W6_d4.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PostExceptionHandler {

    @ExceptionHandler(NonTrovatoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiError nonTrovatoExceptionHandler(NonTrovatoException e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setDataErrore(LocalDateTime.now());

        return apiError;
    }

    @ExceptionHandler(ValidationEx.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError validationExHandler(ValidationEx e){
        ApiError apiError = new ApiError();
        apiError.setMessage(e.getMessage());
        apiError.setDataErrore(LocalDateTime.now());

        return apiError;
    }
}
