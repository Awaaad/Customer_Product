package com.onetomany.mapper;

import com.onetomany.dto.CustomerDto;
import com.onetomany.dto.ProductDto;
import com.onetomany.entity.Customer;
import com.onetomany.entity.Product;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-24T09:35:16+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 11.0.5 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto mapCustomerEntityToDto(Customer customerEntity) {
        if ( customerEntity == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customerEntity.getId() );
        customerDto.setName( customerEntity.getName() );
        customerDto.setEmail( customerEntity.getEmail() );
        customerDto.setGender( customerEntity.getGender() );
        customerDto.setProducts( productListToProductDtoList( customerEntity.getProducts() ) );

        return customerDto;
    }

    @Override
    public Customer mapCustomerDtoToEntity(CustomerDto customerDto) {
        if ( customerDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( customerDto.getId() );
        customer.setName( customerDto.getName() );
        customer.setEmail( customerDto.getEmail() );
        customer.setGender( customerDto.getGender() );
        customer.setProducts( productDtoListToProductList( customerDto.getProducts() ) );

        return customer;
    }

    protected ProductDto productToProductDto(Product product) {
        if ( product == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        if ( product.getProdId() != null ) {
            productDto.setProdId( product.getProdId() );
        }
        productDto.setProdName( product.getProdName() );
        if ( product.getQuantity() != null ) {
            productDto.setQuantity( product.getQuantity() );
        }
        if ( product.getPrice() != null ) {
            productDto.setPrice( product.getPrice() );
        }

        return productDto;
    }

    protected List<ProductDto> productListToProductDtoList(List<Product> list) {
        if ( list == null ) {
            return null;
        }

        List<ProductDto> list1 = new ArrayList<ProductDto>( list.size() );
        for ( Product product : list ) {
            list1.add( productToProductDto( product ) );
        }

        return list1;
    }

    protected Product productDtoToProduct(ProductDto productDto) {
        if ( productDto == null ) {
            return null;
        }

        Product product = new Product();

        product.setProdId( productDto.getProdId() );
        product.setProdName( productDto.getProdName() );
        product.setQuantity( productDto.getQuantity() );
        product.setPrice( productDto.getPrice() );

        return product;
    }

    protected List<Product> productDtoListToProductList(List<ProductDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Product> list1 = new ArrayList<Product>( list.size() );
        for ( ProductDto productDto : list ) {
            list1.add( productDtoToProduct( productDto ) );
        }

        return list1;
    }
}
