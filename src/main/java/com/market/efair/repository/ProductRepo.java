package com.market.efair.repository;

import com.market.efair.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<Product, Long> {

    Optional<String> findProductByName(String name);
}
