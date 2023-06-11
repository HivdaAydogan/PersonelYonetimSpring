package com.hivda.exceptions;

import lombok.Getter;

/**
 * Bu kısımda uygulamamız içinde oluşabilecek tüm hataları kapsayan bir kapsayıcıya ihtiyacımız var,
 * yani hata tiplerini listesini içeren bir Enum sınıfı oluşturabiliriz.
 * Ayrıca, uygulamamız restApi kurgusunda olduğu için bu hataların Response Entity oluşturmak doğru yaklaşımdır.
 */
@Getter
public class Java8StartException extends RuntimeException{
    private final ErrorType errorType;
    public Java8StartException(ErrorType errorType){
        super(errorType.getMessage());
        this.errorType = errorType;
    }

    public Java8StartException(ErrorType errorType, String message){
        super(message);
        this.errorType = errorType;
    }

}
