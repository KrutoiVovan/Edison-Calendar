package com.tut.vivacloud.controllers;

import com.tut.vivacloud.model.entity.Order;
import com.tut.vivacloud.model.entity.WarehouseItem;
import com.tut.vivacloud.model.repository.WarehouseItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@Slf4j
@RestController
@RequestMapping(value = "/warehouse", produces = "application/json")
public class WarehousItemsController {

    WarehouseItemRepository repo;

    @Autowired
    public WarehousItemsController(WarehouseItemRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/list")
    public Iterable<WarehouseItem> getWarehouseItems(){
        return repo.findAll();
    }

    @PostMapping("/add")
    public ResponseEntity addWarehouseItem(WarehouseItem item){
        try {
            WarehouseItem savedItem = repo.save(item);
            return ResponseEntity.ok(savedItem);
        } catch (Exception e){
            log.error("Error persisting WarehouseItem " + item);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable("id") Integer id) {
        log.info("Request to delete " + id);
        Optional<WarehouseItem> warehouseItem = repo.findById(id);
        if (warehouseItem.isPresent()) {
            repo.delete(warehouseItem.get());
            return ResponseEntity.ok(null);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
    }

}
