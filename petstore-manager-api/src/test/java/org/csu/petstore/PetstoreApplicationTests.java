package org.csu.petstore;

import org.csu.petstore.controller.UserController;
import org.csu.petstore.domain.*;
import org.csu.petstore.service.*;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

import java.util.List;

@SpringBootTest
@MapperScan("org.csu.petstore.persistence")
class PetstoreApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        User user = userService.login("admin", "admin");

        System.out.println(user.getId() + ", " + user.getEmail());
    }

}
