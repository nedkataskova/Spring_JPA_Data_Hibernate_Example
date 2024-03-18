package com.jpa.demo.service;

import com.jpa.demo.model.Product;
import com.jpa.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> getProducts(){
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public Product getProductByName(String name) {
        return productRepository.findByName(name);
    }

    public String deleteProduct(Long id) {
        productRepository.deleteById(id);
        return "Product with id: " + id + " is removed";
    }

    public Product updateProduct(Product product) {
        Product existingProduct = productRepository.findById(product.getId()).orElse(null);
        if(existingProduct != null) {
            existingProduct.setName(product.getName());
            existingProduct.setDescription(product.getDescription());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setImageUrl(product.getImageUrl());
            existingProduct.setActive(true);
            existingProduct.setDateCreated(LocalDateTime.now());
            existingProduct.setLastUpdated(LocalDateTime.now());
            return productRepository.save(existingProduct);
        }
        return null;
    }
}
