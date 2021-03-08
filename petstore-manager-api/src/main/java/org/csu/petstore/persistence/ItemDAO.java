package org.csu.petstore.persistence;

import org.csu.petstore.domain.Item;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDAO {
    Item findByItemId(Item item);
}
