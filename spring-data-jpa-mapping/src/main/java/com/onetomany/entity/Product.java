package com.onetomany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Product {

    @Id
    private Long prodId;
    private String prodName;
    private Long quantity;
    private Long price;
}
