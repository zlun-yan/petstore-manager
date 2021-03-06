package org.csu.petstore.service;

import org.csu.petstore.domain.User;

public interface UserService {
    User login(User user);

    User login(String username, String password);
}
