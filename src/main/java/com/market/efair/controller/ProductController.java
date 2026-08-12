package com.market.efair.controller;

import com.market.efair.entity.Product;
import com.market.efair.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/")
    public String loadPage(Model model){
        model.addAttribute("allProducts", productService.getAllProducts());

        return "/product/ControlPanel";
    }

    @PostMapping("/register")
    public String registerProduct(@ModelAttribute Product product){

        try {

            productService.registerNewProduct(product);

        }catch (Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }

        return "redirect:/product/";
    }

    @GetMapping("/add")
    public String addNewProductPage(Model model){
        model.addAttribute("product", new Product());

        return "/product/ProdForm";
    }

    @PostMapping("/add")
    public String addNewProduct(@ModelAttribute Product product){

        try {

            productService.registerNewProduct(product);
        }catch (Exception ex){
            System.out.println("ERROR: " + ex.getMessage());
        }

        return "redirect:/product/";

    }


}
