package com.onetomany.service;

import com.onetomany.dto.CountProductsDto;
import com.onetomany.dto.ProductDto;
import com.onetomany.entity.Product;
import com.onetomany.exception.CustomerNotFound;
import com.onetomany.repository.ProductRepository;
import com.onetomany.service.implementation.ProductServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

public interface ProductService {

    List<ProductDto> findAllProducts();

    ProductDto findProductById(long prodId);

    void saveProduct(ProductDto productDto);

    void deleteProduct(long prodId);

    void deleteProductByName(String prodName);

    void editProduct(ProductDto productDto);

    List<ProductDto> findProductByName(String prodName);

    CountProductsDto countProductByName(String prodName);
//    @Autowired
//    private ProductRepository repo;

//  list all products
//    public List<Product> findAll() {
//        return (List<Product>)repo.findAll();
//    }

//    list product by Id
//    public Product findById(long prodId) {
//        return repo.findById(prodId).get();
//    }

//  delete product by Id
//    public void delete(long prodId){
//        repo.deleteById(prodId);
//    }
}
