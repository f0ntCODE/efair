package com.market.efair.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.efair.entity.Order;


public interface OrderRepo extends JpaRepository<Order, Long> {

}
