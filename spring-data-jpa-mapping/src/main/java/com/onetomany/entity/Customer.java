package com.onetomany.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity

public class Customer {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String email;
    private String gender;

    @OneToMany(targetEntity =  Product.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private List<Product> products;
}
