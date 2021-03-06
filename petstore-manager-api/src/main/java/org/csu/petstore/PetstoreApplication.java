package org.csu.petstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("org.csu.petstore.persistence")
public class PetstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(PetstoreApplication.class, args);
    }

}
