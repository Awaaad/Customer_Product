package com.onetomany.mapper;

import com.onetomany.dto.ProductDto;
import com.onetomany.entity.Product;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-02-11T19:31:47+0400",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_172 (Oracle Corporation)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public ProductDto mapProductEntityToDto(Product productEntity) {
        if ( productEntity == null ) {
            return null;
        }

        ProductDto productDto = new ProductDto();

        if ( productEntity.getProdId() != null ) {
            productDto.setProdId( productEntity.getProdId() );
        }
        productDto.setProdName( productEntity.getProdName() );
        if ( productEntity.getQuantity() != null ) {
            productDto.setQuantity( productEntity.getQuantity() );
        }
        if ( productEntity.getPrice() != null ) {
            productDto.setPrice( productEntity.getPrice() );
        }

        return productDto;
    }

    @Override
    public Product mapProductDtoToEntity(ProductDto productDto) {
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
}
