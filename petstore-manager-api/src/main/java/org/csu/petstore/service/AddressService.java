package org.csu.petstore.service;

import org.csu.petstore.domain.Address;

import java.util.List;

public interface AddressService {
    List<Address> getAddressByUserId(Integer user_id);
}
