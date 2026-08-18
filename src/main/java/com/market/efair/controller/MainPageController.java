package com.market.efair.controller;

import com.market.efair.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainPageController {

    private final ProductService productService;

    public MainPageController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public String upMainPage(Model model){

        model.addAttribute("product", productService.getAllProducts());

        return "/public/mainPage";
    }

}
