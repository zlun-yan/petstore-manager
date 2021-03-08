package org.csu.petstore.service.Impl;

import org.csu.petstore.domain.User;
import org.csu.petstore.persistence.UserDAO;
import org.csu.petstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public User login(String username, String password) {
        User user = userDAO.findByUsername(username);

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
