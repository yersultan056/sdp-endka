package kz.sdppj.sdpendka.controller;

import kz.sdppj.sdpendka.model.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String getProducts(Model model) {
        List<Product> products = Arrays.asList(
                new Product(1L, "Product 1", 10.99),
                new Product(2L, "Product 2", 20.99),
                new Product(3L, "Product 3", 30.99)
        );

        model.addAttribute("products", products);
        return "products";
    }
}