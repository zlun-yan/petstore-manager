package org.csu.petstore.service.Impl;

import org.csu.petstore.domain.Shop;
import org.csu.petstore.persistence.ShopDAO;
import org.csu.petstore.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopDAO shopDAO;


    @Override
    public Shop getShopByName(String name) {
        return shopDAO.findByName(name);
    }
}
