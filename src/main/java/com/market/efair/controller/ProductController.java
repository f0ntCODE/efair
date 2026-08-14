package com.market.efair.controller;

import com.market.efair.entity.Product;
import com.market.efair.exception.AlreadyExistException;
import com.market.efair.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping()
    public String loadPage(Model model){
        model.addAttribute("allProducts", productService.getAllProducts());

        return "product/ControlPanel";
    }

    @PostMapping("/register")
    public String registerProduct(@ModelAttribute Product product){

        try {

            productService.registerNewProduct(product);

        }catch (Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }

        return "redirect:/product";
    }

    @GetMapping("/add")
    public String addNewProductPage(Model model){
        model.addAttribute("product", new Product());

        return "product/AddProdForm";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product){

        try {

            productService.registerNewProduct(product);

        }catch (Exception ex){

            System.out.println("ERROR: " + ex.getMessage());

        }

        return "redirect:/product";

    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable long id,
                                  Model model){

        Product foundProduct = productService.getProduct(id);

        System.out.println("Selected prod: " + foundProduct.getName());
        model.addAttribute("product", foundProduct);

        return "product/EditProdForm";
    }

    @PostMapping("/edit/{id}")
    public String editProduct(@ModelAttribute Product newProductInfo,
                              @PathVariable long id){

        try {

            productService.editProduct(id, newProductInfo);

        }catch (AlreadyExistException ex){

            System.out.println("ERROR: " + ex.getMessage());

        }

        return "redirect:/product";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable long id){

        productService.deleteProduct(id);

        return "redirect:/product";

    }


}
