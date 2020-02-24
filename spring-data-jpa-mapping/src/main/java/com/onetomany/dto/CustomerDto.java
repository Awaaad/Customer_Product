package com.onetomany.dto;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    private long id;
    private String name;
    private String email;
    private String gender;
    private List<ProductDto> products;
}
