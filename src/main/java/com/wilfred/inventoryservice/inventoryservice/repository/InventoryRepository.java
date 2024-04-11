package com.wilfred.inventoryservice.inventoryservice.repository;

import com.wilfred.inventoryservice.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, String quantity);
}
