package org.csu.petstore.persistence;

import org.csu.petstore.domain.Address;
import org.csu.petstore.domain.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDAO {

    List<Address> findByUserId(User user);
}
