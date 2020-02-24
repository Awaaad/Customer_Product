package com.onetomany.mapper;

import com.onetomany.dto.CustomerDto;
import com.onetomany.entity.Customer;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto mapCustomerEntityToDto (Customer customerEntity);
    @InheritInverseConfiguration
    Customer mapCustomerDtoToEntity (CustomerDto customerDto);
}
