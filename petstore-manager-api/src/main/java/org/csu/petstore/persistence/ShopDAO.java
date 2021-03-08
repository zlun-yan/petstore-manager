package org.csu.petstore.persistence;

import org.csu.petstore.domain.Shop;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopDAO {

    Shop findByName(String name);
}
