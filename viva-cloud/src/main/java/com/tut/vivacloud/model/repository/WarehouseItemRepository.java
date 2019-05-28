package com.tut.vivacloud.model.repository;

import com.tut.vivacloud.model.entity.WarehouseItem;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface WarehouseItemRepository
            extends CrudRepository<WarehouseItem, Integer> {
}
