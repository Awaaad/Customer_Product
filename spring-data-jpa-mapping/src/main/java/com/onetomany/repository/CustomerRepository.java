package com.onetomany.repository;

import com.onetomany.dto.OrderQueryNamesDto;
import com.onetomany.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("select new com.onetomany.dto.OrderQueryNamesDto(c.name, p.prodName) from Customer c inner join c.products p")
    public List<OrderQueryNamesDto> getCustomerProductName();

    public List<Customer> findByproducts_prodName(String productName);

    public List<Customer> findBygender(String gender);
}
