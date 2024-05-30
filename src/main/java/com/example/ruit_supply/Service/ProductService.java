package com.example.ruit_supply.Service;

import com.example.ruit_supply.Entity.Product;
import com.example.ruit_supply.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }
    public Product createProduct(Product product)
    {
        return productRepository.save(product);
    }
    @Transactional
    public Product updateProduct(Long id, Product productNew)
    {
        Product product = productRepository.findById(id).
                orElseThrow(()-> new RuntimeException("Product not found"));
        product.setName(productNew.getName());
        product.setType(productNew.getType());
        return productRepository.save(product);
    }
}
