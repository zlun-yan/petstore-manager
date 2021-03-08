package org.csu.petstore.service.Impl;

import org.csu.petstore.domain.AdminRole;
import org.csu.petstore.persistence.AdminRoleDAO;
import org.csu.petstore.service.AdminRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminRoleServiceImpl implements AdminRoleService {

    @Autowired
    private AdminRoleDAO adminRoleDAO;

    @Override
    public AdminRole getAdminRoleByRoleId(Integer id) {
        return adminRoleDAO.findById(id);
    }
}
