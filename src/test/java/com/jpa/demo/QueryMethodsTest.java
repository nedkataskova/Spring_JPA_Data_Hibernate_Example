package com.jpa.demo;

import com.jpa.demo.model.Product;
import com.jpa.demo.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
public class QueryMethodsTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void findByNameMethod(){

        Product product = productRepository.findByName("Product 2");

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByIdMethod(){
        Product product = productRepository.findById(1L).get();

        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByNameOrDescriptionMethod(){

        List<Product> products = productRepository.findByNameOrDescription("Product 1",
                "Product 1 description");

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameAndDescriptionMethod(){

        List<Product> products = productRepository.findByNameAndDescription("Product 1",
                "product 1 description");

        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findDistinctByNameMethod(){

        Product product = productRepository.findDistinctByName("Product 1");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getDescription());
    }

    @Test
    void findByPriceGreaterThanMethod(){
        List<Product> products = productRepository.findByPriceGreaterThan(new BigDecimal(100));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceLessThanMethod(){

        List<Product> products = productRepository.findByPriceLessThan(new BigDecimal(200));
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameContainingMethod(){

        List<Product> products = productRepository.findByNameContaining("Product 1");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByNameLikeMethod(){

        List<Product> products = productRepository.findByNameLike("Product 1");
        products.forEach((p) -> {
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }

    @Test
    void findByPriceBetweenMethod(){
        List<Product> products = productRepository.findByPriceBetween(
                new BigDecimal(100), new BigDecimal(300)
        );

        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });

    }

    @Test
    void findByDateCreatedBetweenMethod(){

        // start date
        LocalDateTime startDate = LocalDateTime.of(2024, 1, 1, 18, 0, 0);
        // end date
        LocalDateTime endDate = LocalDateTime.of(2024, 10, 10, 18, 0, 0);

        List<Product> products = productRepository.findByDateCreatedBetween(startDate, endDate);

        products.forEach((p) ->{
            System.out.println(p.getId());
            System.out.println(p.getName());
        });
    }
}
