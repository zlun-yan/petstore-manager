package org.csu.petstore.persistence;

import org.csu.petstore.domain.AdminRole;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRoleDAO {

    AdminRole findById(Integer id);
}
