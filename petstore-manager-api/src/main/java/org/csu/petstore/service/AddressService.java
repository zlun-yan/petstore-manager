package org.csu.petstore.service;

import org.csu.petstore.domain.Address;
import org.csu.petstore.domain.User;

import java.util.List;

public interface AddressService {
    List<Address> getAddressByUserId(User user);
}
