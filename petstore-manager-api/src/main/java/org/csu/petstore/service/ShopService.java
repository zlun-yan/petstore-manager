package org.csu.petstore.service;

import org.csu.petstore.domain.Shop;

public interface ShopService {

    Shop getShopByName(String name);
}
