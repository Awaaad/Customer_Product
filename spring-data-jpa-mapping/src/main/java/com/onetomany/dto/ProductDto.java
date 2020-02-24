package com.onetomany.dto;

import lombok.Data;

@Data
public class ProductDto {

    private long prodId;
    private String prodName;
    private long quantity;
    private long price;
}
