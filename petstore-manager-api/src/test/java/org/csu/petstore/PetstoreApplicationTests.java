package org.csu.petstore;

import org.csu.petstore.controller.UserController;
import org.csu.petstore.domain.User;
import org.csu.petstore.service.UserService;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootTest
@MapperScan("org.csu.petstore.persistence")
class PetstoreApplicationTests {

    @Autowired
    private UserService userService;

    @Autowired
    private UserController userController;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
//        User user = new User();
//        user.setUsername("admin");
//        user.setPassword("admin");
//        user = userService.login(user);
//
//        System.out.println(user.getId() + ", " + user.getUsername() + ", " + user.getPassword() + ", " + user.getEmail());
        userController.zlunMethod();
    }

}
