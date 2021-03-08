package org.csu.petstore.persistence;

import org.csu.petstore.domain.Address;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDAO {

    List<Address> findByUserId(Integer user_id);
}
