package com.market.efair.service;

import com.market.efair.entity.Product;
import com.market.efair.exception.AlreadyExistException;
import com.market.efair.exception.NotFoundException;
import com.market.efair.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepo productRepo;

    public ProductService(ProductRepo productRepo){

        this.productRepo = productRepo;
    }

    public void registerNewProduct(Product product) throws Exception {

        if(isProductAlreadyExist(product.getName())){

            throw new Exception("This product already exist");

        }

        Product newProduct = new Product(
                product.getName(),
                product.getDescr(),
                product.getUnitPrice()
        );

        productRepo.save(newProduct);

    }

    public void editProduct(long id, Product newProductInfo){

        Product foundProduct = productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));

        if(isProductAlreadyExist(newProductInfo.getName())) throw new AlreadyExistException("This product already exist");


        productRepo.save(foundProduct.editInfo(newProductInfo));

    }

    public void deleteProduct(long id) {

        productRepo.deleteById(id);
    }

    private boolean isProductAlreadyExist(String name){

        return (productRepo.findProductByName(name).isPresent());
    }

    public List<Product> getAllProducts(){

        return List.copyOf(productRepo.findAll());
    }

    public Product getProduct(long id){

        return productRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }
}
