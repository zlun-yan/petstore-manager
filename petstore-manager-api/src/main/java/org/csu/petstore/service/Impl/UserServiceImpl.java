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
    public User login(User user) {
        return userDAO.findByUsernameAndPassword(user);
    }

    @Override
    public User login(String username, String password) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return userDAO.findByUsernameAndPassword(user);
    }
}
