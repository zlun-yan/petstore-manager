package org.csu.petstore.service.Impl;

import org.csu.petstore.domain.Item;
import org.csu.petstore.persistence.ItemDAO;
import org.csu.petstore.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemDAO itemDAO;

    @Override
    public Item getItemByItemId(Integer id) {
        return itemDAO.findByItemId(id);
    }
}
