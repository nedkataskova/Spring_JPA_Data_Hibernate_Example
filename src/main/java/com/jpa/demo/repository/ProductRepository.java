package com.jpa.demo.repository;

import com.jpa.demo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Returns the found product entry by using its name as search
     * criteria. If no product entry is found, this method
     * returns null.
     */
    Product findByName(String name);

    /**
     * Returns an Optional which contains the found product
     * entry by using its id as search criteria. If no product entry
     * is found, this method returns an empty Optional.
     */
    Optional<Product> findById(Long id);

    /**
     * Returns the found list of product entries whose name or description is given
     * as a method parameters. If no product entries is found, this method
     * returns an empty list.
     */
    List<Product> findByNameOrDescription(String name, String description);

    /**
     * Returns the found list of product entries whose name and description is given
     * as a method parameters. If no product entries is found, this method
     * returns an empty list.
     */
    List<Product> findByNameAndDescription(String name, String description);

    /**
     * Return the distinct product entry whose name is given as a method parameter
     *  If no product entry is found, this method returns null.
     */
    Product findDistinctByName(String name);

    /**
     * Return the products whose price is greater than given price as method parameter
     * @param price
     * @return
     */
    List<Product> findByPriceGreaterThan(BigDecimal price);

    /**
     * Return the products whose price is less than given price as method parameter
     * @param price
     * @return
     */
    List<Product> findByPriceLessThan(BigDecimal price);

    /**
     * Return the filtered the product records that match the given text
     * @param name
     * @return
     */
    List<Product> findByNameContaining(String name);

    /**
     * Return products based on SQL like condition
     * @param name
     * @return
     */
    List<Product> findByNameLike(String name);

    /**
     * Returns a products whose price between start price and end price
     * @param startPrice
     * @param endPrice
     * @return
     */
    List<Product> findByPriceBetween(BigDecimal startPrice, BigDecimal endPrice);

    /**
     * Returns a products whose dateCreated between start date and end date
     * @param startDate
     * @param endDate
     * @return
     */
    List<Product> findByDateCreatedBetween(LocalDateTime startDate, LocalDateTime endDate);


    /**
     * Returns a products whose description contains description
     * @param description
     * @return
     */

    //Creation database query with @Query annotation and JPQL
    @Query("select p from Product p where p.description like %?1")
    List<Product> findProductByContainingDescription(String description);
}
