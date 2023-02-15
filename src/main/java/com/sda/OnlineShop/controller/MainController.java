package com.sda.OnlineShop.controller;

import com.sda.OnlineShop.dto.ProductDto;
import com.sda.OnlineShop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
    @Autowired
    private ProductService productService;

    @GetMapping("/addProduct")
    public String addProductGet(Model model) {
        ProductDto productDto = new ProductDto();
        model.addAttribute("productDto",productDto);
        return "addProduct";            // here we add the view name from spring MVC
    }

    @PostMapping("/addProduct")
    public String addProductPost(@ModelAttribute ProductDto productDto) {
        productService.addProduct(productDto);
        System.out.println(productDto);
        return "addProduct";
    }
}
