package org.csu.petstore.persistence;

import org.csu.petstore.domain.AdminUser;

public interface AdminUserDAO {
    AdminUser findByUserId(AdminUser user);
}
