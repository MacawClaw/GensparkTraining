package com.example.ProductDBSecurity.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product_record")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    //ISBN used as Id
    @Id
    @Column(name = "upc")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int upc;

    @NonNull
    private String productName;

    @NonNull
    private String manufacturer;

    @NonNull
    private BigDecimal price;

    @NonNull
    private String description;
}
