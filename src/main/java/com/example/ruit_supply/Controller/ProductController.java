package com.example.ruit_supply.Controller;

import com.example.ruit_supply.Entity.Product;
import com.example.ruit_supply.Service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
@Slf4j

public class ProductController {
    @Autowired
    private ProductService productService;


    @GetMapping
    public List<Product> getAllProducts()
    {
        return productService.getAllProducts();
    }


    @PostMapping
    public Product createProduct(@RequestBody Product product)
    {
        return productService.createProduct(product);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product)
    {
        return productService.updateProduct(id, product);
    }
}
