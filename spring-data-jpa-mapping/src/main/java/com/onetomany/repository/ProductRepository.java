package com.onetomany.repository;

import com.onetomany.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT a FROM Product a WHERE a.prodName LIKE CONCAT('%',:prodName,'%')")
    List<Product> findProductByName(String prodName);

    public void deleteByprodName(String prodName);

    public Integer countByprodName(String prodName);
}
