package com.market.efair.service;

import com.market.efair.entity.Product;
import com.market.efair.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){

        this.productRepo = productRepo;
    }

    public Product registerNewProduct(Product product) throws Exception {

        if(isProductAlreadyExist(product.getName())){

            throw new Exception("This product already exist");

        }

        Product newProduct = new Product(
                product.getName(),
                product.getDescr(),
                product.getUnitPrice()
        );

        return productRepo.save(newProduct);

    }

    private boolean isProductAlreadyExist(String name){

        return (productRepo.findProductByName(name).isPresent());
    }

    public List<Product> getAllProducts(){

        return List.copyOf(productRepo.findAll());
    }

}
