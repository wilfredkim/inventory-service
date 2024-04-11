package com.wilfred.inventoryservice.inventoryservice.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_inventories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "sku_code")
    private String skuCode;
    @Column(name = "quantity")
    private String quantity;
}
