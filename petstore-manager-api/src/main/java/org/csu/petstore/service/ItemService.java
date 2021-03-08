package org.csu.petstore.service;

import org.csu.petstore.domain.Item;

public interface ItemService {

    Item getItemByItemId(Integer id);
}
