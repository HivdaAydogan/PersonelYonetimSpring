package com.hivda.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseEntity<String> hatalariYakalayanBenim(Exception ex){
        String olusanHata = ex.toString();
        return ResponseEntity.ok("Beklenmeyen bir hata oldu, detay...: "+olusanHata);
    }

}
