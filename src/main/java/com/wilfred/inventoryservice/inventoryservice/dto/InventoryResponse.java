package com.wilfred.inventoryservice.inventoryservice.dto;

import lombok.Builder;

@Builder
public record InventoryResponse(Long id, String skuCode, String quantity) {
}
