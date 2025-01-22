package com.secor.ecominventoryservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final Logger LOG = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryRepository inventoryRepository;

    @GetMapping
    public List<Inventory> getAllInventory() {
        LOG.info("Get all inventory");
        return inventoryRepository.findAll();
    }

    @GetMapping("/{productId}")
    public Inventory getInventoryForProductId(@PathVariable Long productId) {
        LOG.info("Get inventory for product id {}", productId);
        return inventoryRepository.findByProductId(productId);
    }

    @PostMapping
    public Inventory addInventory(@RequestBody Inventory inventory) {
        LOG.info("Add inventory {}", inventory);
        return inventoryRepository.save(inventory);
    }

    @PutMapping("/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestBody Inventory inventoryDetails) {
        LOG.info("Update inventory {}", inventoryDetails);
        Inventory inventory = inventoryRepository.findById(id).orElseThrow();
        inventory.setProductId(inventoryDetails.getProductId());
        inventory.setQuantity(inventoryDetails.getQuantity());
        inventory.setLastUpdated(inventoryDetails.getLastUpdated());
        return inventoryRepository.save(inventory);
    }

    @DeleteMapping("/{id}")
    public void deleteInventory(@PathVariable Long id) {
        LOG.info("Delete inventory {}", id);
        inventoryRepository.deleteById(id);
    }
}

