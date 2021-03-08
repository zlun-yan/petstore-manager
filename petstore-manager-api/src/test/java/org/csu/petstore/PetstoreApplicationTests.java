package org.csu.petstore;

import org.csu.petstore.controller.UserController;
import org.csu.petstore.domain.Address;
import org.csu.petstore.domain.AdminRole;
import org.csu.petstore.domain.User;
import org.csu.petstore.service.AddressService;
import org.csu.petstore.service.AdminRoleService;
import org.csu.petstore.service.UserService;
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
    private AdminRoleService adminRoleService;

    @Test
    void contextLoads() {
    }

    @Test
    void test() {
        AdminRole role = adminRoleService.getAdminRoleByRoleId(1);
        System.out.println(role.getId() + ", " + role.getRole_name() + ", " + role.getCreateDate());
    }

}
