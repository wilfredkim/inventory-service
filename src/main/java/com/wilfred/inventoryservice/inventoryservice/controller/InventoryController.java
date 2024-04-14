package com.wilfred.inventoryservice.inventoryservice.controller;

import com.wilfred.inventoryservice.inventoryservice.dto.InventoryRequest;
import com.wilfred.inventoryservice.inventoryservice.dto.InventoryResponse;
import com.wilfred.inventoryservice.inventoryservice.model.Inventory;
import com.wilfred.inventoryservice.inventoryservice.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inventories")
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam String quantity) {
        return inventoryService.isInStock(skuCode, quantity);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public InventoryResponse addInventory(@RequestBody InventoryRequest inventoryRequest) {
        return inventoryService.addInventory(inventoryRequest);
    }

    @GetMapping("/list")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> getList() {
        return inventoryService.getList();
    }
}
