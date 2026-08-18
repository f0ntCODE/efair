package com.market.efair.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String descr;
    private double unitPrice;
    private String imagePath;

    public Product() {}

    public Product(String name,
                   String descr,
                   double unitPrice) {

        this.name = name;
        this.descr = descr;
        this.unitPrice = unitPrice;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Product editInfo(Product newInfo){

         this.name = newInfo.getName();
         this.unitPrice = newInfo.getUnitPrice();
         this.descr = newInfo.getDescr();
         this.imagePath = newInfo.getImagePath();

        return this;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
