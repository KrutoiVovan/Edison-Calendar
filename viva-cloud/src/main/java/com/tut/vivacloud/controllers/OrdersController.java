package com.tut.vivacloud.controllers;

import com.tut.vivacloud.model.entity.Order;
import com.tut.vivacloud.model.entity.WarehouseItem;
import com.tut.vivacloud.model.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping(value = "/orders", produces = "application/json")
public class OrdersController {

    private OrderRepository repo;

    @Autowired
    public OrdersController(OrderRepository repo) {
        this.repo = repo;
    }


    @GetMapping(value = "/list", produces = "application/json")
    public Iterable<Order> getGoodsList() {
        return repo.findAll();
    }

    @GetMapping(value = "/between", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<Order> getGoodsListBetweenDate(@RequestParam Date date, @RequestHeader HttpHeaders headers) {
        log.info("List request from " + headers.getHost());
        return repo.findActiveOrdersToDate(date);
    }

    @PostMapping
    public void updateList(Order item) {
        log.info("Request to add " + item);
        repo.save(item);
        return;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") Integer id) {
        log.info("Request to delete " + id);
        Optional<Order> order = repo.findById(id);
        if (order.isPresent()) {
            repo.delete(order.get());
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
