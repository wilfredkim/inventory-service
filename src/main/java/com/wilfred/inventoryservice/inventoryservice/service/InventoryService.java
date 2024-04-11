package com.wilfred.inventoryservice.inventoryservice.service;

import com.wilfred.inventoryservice.inventoryservice.dto.InventoryRequest;
import com.wilfred.inventoryservice.inventoryservice.dto.InventoryResponse;
import com.wilfred.inventoryservice.inventoryservice.model.Inventory;
import com.wilfred.inventoryservice.inventoryservice.repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public boolean isInStock(String skuCode, String quantity) {
        log.info("  {}", skuCode + " {}" + quantity);
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode, quantity);
    }

    public InventoryResponse addInventory(InventoryRequest inventoryRequest) {
        Inventory inventory = Inventory.builder().skuCode(inventoryRequest.skuCode()).quantity(inventoryRequest.quantity()).build();
        inventory = inventoryRepository.save(inventory);
        return InventoryResponse.builder().id(inventory.getId()).skuCode(inventory.getSkuCode()).quantity(inventory.getQuantity()).build();

    }
}
