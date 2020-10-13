package br.com.zup.bootcamp.bolao.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HandlerErro {

    private final Logger log = LoggerFactory.getLogger(HandlerErro.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handle (MethodArgumentNotValidException methodArgumentNotValidException){
        log.info("Tratando {}", methodArgumentNotValidException);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new String ("Teste do Luram"));
    }
}
