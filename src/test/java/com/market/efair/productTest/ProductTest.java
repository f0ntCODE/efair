package com.market.efair.productTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.market.efair.entity.Product;
import com.market.efair.service.ProductService;

@ActiveProfiles("test")
@SpringBootTest 
public class ProductTest {

    @Autowired 
    private ProductService productService;

    @Test
    void test(){
        //there's nothing here :)
    }

    @BeforeEach
    void setup(){
        
    }

    @Test
    @DisplayName("A product must be created and saved")
    void aProductMustBeCreatedAndSavedInTheDatabase() throws Exception{
        
        BigDecimal preco = new BigDecimal(125);
        Product prod = new Product(
            "Cadeira",
            "Cadeira confortável",
            preco
        );

        Product productCreated = productService.registerNewProduct(prod);

        assertEquals(prod.getName(), productCreated.getName());

    }

    @Test
    @DisplayName("Change a product info")
    void infoOfProductMustBeChanged(){

    }

}
