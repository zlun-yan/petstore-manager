package org.csu.petstore.service.Impl;

import org.csu.petstore.domain.AdminUser;
import org.csu.petstore.persistence.AdminUserDAO;
import org.csu.petstore.service.AdminUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminUserServiceImpl implements AdminUserService {

    @Autowired
    private AdminUserDAO adminUserDAO;

    @Override
    public AdminUser login(String username, String password) {
        AdminUser user = adminUserDAO.findByUsername(username);

        if (user == null) {
            System.out.println("该用户【" + username + "】不存在");

            return null;
        }
        else {
            if (user.getPassword().equals(password)) {
                return user;
            }
        }

        System.out.println("该用户【" + username + "】密码错误");
        return null;
    }
}
