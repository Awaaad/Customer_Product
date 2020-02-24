package com.onetomany.mapper;

import com.onetomany.dto.ProductDto;
import com.onetomany.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDto mapProductEntityToDto (Product productEntity);

    @InheritInverseConfiguration
    Product mapProductDtoToEntity (ProductDto productDto);
}
