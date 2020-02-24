package com.onetomany.controller;

import com.onetomany.dto.CountProductsDto;
import com.onetomany.dto.ProductDto;
import com.onetomany.repository.ProductRepository;
import com.onetomany.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    // GET GOES HERE
    @GetMapping("/allProducts")
    public List<ProductDto> findAllProducts(){
        return productService.findAllProducts();
    }

    @GetMapping("/productId/{prodId}")
    public ResponseEntity<ProductDto>getByProductId(@PathVariable Long prodId){
        return new ResponseEntity<>(productService.findProductById(prodId), HttpStatus.OK);
    }

    @GetMapping("searchProduct/{prodName}")
    public ResponseEntity<List<ProductDto>>getProductByName(@PathVariable String prodName){
        return  new ResponseEntity<>(productService.findProductByName(prodName), HttpStatus.OK);
    }

    @GetMapping("countProductByName/{prodName}")
    public ResponseEntity<CountProductsDto>getProductCountByName(@PathVariable String prodName){
        return new ResponseEntity<>(productService.countProductByName(prodName), HttpStatus.OK);
    }
    // POST GOES HERE
    @PostMapping("saveProduct")
    public ResponseEntity saveProduct(@RequestBody ProductDto productDto){
        productService.saveProduct(productDto);
        return new ResponseEntity<String>("Product saved successfully!", HttpStatus.OK);
    }

    // PUT GOES HERE
    @PutMapping("/editProduct")
    public ResponseEntity editProduct(@RequestBody ProductDto productDto){
        productService.editProduct(productDto);
        return new ResponseEntity<String>("Product edited successfully!", HttpStatus.OK);
    }

    // DELETE GOES HERE
    @DeleteMapping("deleteProduct/{prodId}")
    public ResponseEntity<String> deleteProduct(@PathVariable long prodId){
        productService.deleteProduct(prodId);
        return new ResponseEntity<String>("Product deleted successfully!", HttpStatus.OK);
    }

    @DeleteMapping("deleteProductByName/{prodName}")
    public ResponseEntity<String> deleteProductByName(@PathVariable String prodName){
        productService.deleteProductByName(prodName);
        return new ResponseEntity<String>("Product deleted successfully!", HttpStatus.OK);
    }
}
