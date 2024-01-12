package com.niq.niqactivateservice.model;/* Created by Indunil Prasanna */

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ShopperProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="shopper_id")
    private Shopper shopper;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

    private BigDecimal relevancyScore;
}
