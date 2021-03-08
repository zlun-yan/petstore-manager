package org.csu.petstore.service;

import org.csu.petstore.domain.AdminUser;

public interface AdminUserService {

    AdminUser login(String username, String password);
}
