package com.market.efair.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "order")
public class Order {

    @Id 
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", referencedColumnName = "id")
    private Client clientId;
    
    private LocalDateTime createdAt;
    
    private BigDecimal subTotal;
    private BigDecimal shipping;
    private BigDecimal total;
    
    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    private List<OrderItem> items = new ArrayList<>();
    
    public Order() {}

    public Order(Client clientId, 
        LocalDateTime createdAt, 
        List<OrderItem> items, 
        BigDecimal subTotal, 
        BigDecimal shipping, 
        BigDecimal total) {

        this.clientId = clientId;
        this.createdAt = createdAt;
        this.items = items;
        this.subTotal = subTotal;
        this.shipping = shipping;
        this.total = total;
    
    }


}
