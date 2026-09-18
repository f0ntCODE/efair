package com.market.efair.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity 
public class OrderItem {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO) 
    private long id;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;
    
    @ManyToOne 
    @JoinColumn (name = "order_id", nullable = false)
    private Order order; 

    private int quantity;
    private BigDecimal subTotal;


    public OrderItem() {}


}
