package com.hivda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Bu sınıfın bir spring boot uygulamasına ait olduğu ve gerekli olan bağımlılıkların
 * buradan itibaren tarandığı belirtiliyor.
 */

@SpringBootApplication
public class Java8startApplication {

	public static void main(String[] args) {
		SpringApplication.run(Java8startApplication.class, args);
	}

}
