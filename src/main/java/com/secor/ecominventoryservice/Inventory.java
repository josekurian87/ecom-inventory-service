package com.secor.ecominventoryservice;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long inventoryId;

    private Long productId;
    private Integer quantity;

    private LocalDateTime lastUpdated;

    // Getters and Setters
}
