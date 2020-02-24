package com.onetomany.service.implementation;

import com.onetomany.dto.CountProductsDto;
import com.onetomany.dto.ProductDto;
import com.onetomany.entity.Product;
import com.onetomany.mapper.ProductMapper;
import com.onetomany.repository.ProductRepository;
import com.onetomany.service.ProductService;
import lombok.var;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Transactional
@Service
public class ProductServiceImp implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductServiceImp(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> findAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(productMapper::mapProductEntityToDto).collect(Collectors.toList());
    }

    @Override
    public ProductDto findProductById(long prodId) {
        Optional<Product> product = productRepository.findById(prodId);
        var oneProduct = product.orElse(null);
        return productMapper.mapProductEntityToDto(oneProduct);
    }

    @Override
    public void saveProduct(ProductDto productDto) {
        var saveProduct = productMapper.mapProductDtoToEntity(productDto);
        productRepository.save(saveProduct);
    }

    @Override
    public void deleteProduct(long prodId) {
        var product = findProductById(prodId);
        if (product != null){
            productRepository.deleteById(prodId);
        } else {
            System.out.println("Product Not Found!");
        }

    }

    @Override
    public void deleteProductByName(String prodName) {
        productRepository.deleteByprodName(prodName);
    }

    @Override
    public void editProduct(ProductDto productDto) {
        var product = findProductById(productDto.getProdId());
        if (product != null) {
            product.setPrice(productDto.getPrice());
            product.setProdName(productDto.getProdName());
            product.setQuantity(productDto.getQuantity());
            productRepository.save(productMapper.mapProductDtoToEntity(product));
        } else {
            System.out.println("Product Not Found!");
        }
    }

    @Override
    public List<ProductDto> findProductByName(String prodName) {
        List<Product> product = productRepository.findProductByName(prodName);
        if (product.size() != 0){
            return product.stream().map(productMapper::mapProductEntityToDto).collect(Collectors.toList());
        }
        else {
            return null;
        }
    }

    @Override
    public CountProductsDto countProductByName(String prodName) {
        Integer countprodName = productRepository.countByprodName(prodName);
        CountProductsDto countProductsDto = new CountProductsDto();
        countProductsDto.setCountProducts(countprodName);
        return countProductsDto;
    }
}
