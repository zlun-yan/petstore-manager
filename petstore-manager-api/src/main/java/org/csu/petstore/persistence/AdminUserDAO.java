package org.csu.petstore.persistence;

import org.csu.petstore.domain.AdminUser;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserDAO {

    AdminUser findByUsername(String username);
}
