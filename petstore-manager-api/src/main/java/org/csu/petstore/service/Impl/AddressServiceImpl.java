package org.csu.petstore.service.Impl;

import org.csu.petstore.domain.Address;
import org.csu.petstore.domain.User;
import org.csu.petstore.persistence.AddressDAO;
import org.csu.petstore.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAO addressDAO;

    @Override
    public List<Address> getAddressByUserId(User user) {
        return addressDAO.findByUserId(user);
    }
}
