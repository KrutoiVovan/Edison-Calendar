package com.tut.vivacloud.model.repository;

import com.tut.vivacloud.model.entity.Order;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface OrderRepository
            extends CrudRepository<Order, Integer> {
    @Query("FROM Order WHERE StartDate > :date and EndDate < :date")
    public List<Order> findActiveOrdersToDate(@Param("date") Date date);
}
