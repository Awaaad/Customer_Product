package com.onetomany.service;

import com.onetomany.dto.CustomerDto;
import com.onetomany.dto.OrderQueryNamesDto;
import com.onetomany.exception.CustomerNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
public interface CustomerService {
    List<CustomerDto> findAllCustomers();

    void saveCustomer (CustomerDto customerDto);

    CustomerDto findCustomerById(long customerId);

    void deleteCustomer (long customerId);

    List<OrderQueryNamesDto> findCustomerProductNames();

    void editCustomer(CustomerDto customerDto);

    List<CustomerDto> findByProduct(String productName);

    List<CustomerDto> findByGender(String gender);


}
