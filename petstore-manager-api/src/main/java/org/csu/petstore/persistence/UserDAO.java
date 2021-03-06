package org.csu.petstore.persistence;

import org.csu.petstore.domain.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
    User findByUsernameAndPassword(User user);
}
