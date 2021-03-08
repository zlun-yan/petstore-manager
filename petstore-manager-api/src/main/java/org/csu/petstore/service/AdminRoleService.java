package org.csu.petstore.service;

import org.csu.petstore.domain.AdminRole;

public interface AdminRoleService {

    AdminRole getAdminRoleByRoleId(AdminRole role);

    AdminRole getAdminRoleByRoleId(Integer id);
}
