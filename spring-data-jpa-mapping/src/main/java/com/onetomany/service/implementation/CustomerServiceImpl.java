package com.onetomany.service.implementation;

import com.onetomany.dto.CustomerDto;
import com.onetomany.dto.OrderQueryNamesDto;
import com.onetomany.entity.Customer;
import com.onetomany.mapper.CustomerMapper;
import com.onetomany.repository.CustomerRepository;
import com.onetomany.service.CustomerService;
import lombok.var;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerDto> findAllCustomers() {
        List<Customer> customers = customerRepository.findAll();
            return customers.stream().map(customerMapper::mapCustomerEntityToDto).collect(Collectors.toList());
    }

    @Override
    public void saveCustomer(CustomerDto customerDto) {
        var saveCustomerData = customerMapper.mapCustomerDtoToEntity(customerDto);
        customerRepository.save(saveCustomerData);
    }

    @Override
    public CustomerDto findCustomerById(long customerId) {
        Optional<Customer> customer = customerRepository.findById(customerId);
        var oneCustomer = customer.orElse(null);
        return customerMapper.mapCustomerEntityToDto(oneCustomer);
    }

    @Override
    public void deleteCustomer(long customerId) {
        var customer = findCustomerById(customerId);
        if (customer != null) {
            customerRepository.deleteById(customerId);
        }
        else {
            System.out.println("Customer Not Found!");
        }
    }

    @Override
    public List<OrderQueryNamesDto> findCustomerProductNames() {
        List<OrderQueryNamesDto> orderQueryNamesDto = customerRepository.getCustomerProductName();
        return orderQueryNamesDto;
    }

    @Override
    public void editCustomer(CustomerDto customerDto) {
        var customer = findCustomerById(customerDto.getId());
        if (customer != null) {
            customer.setName(customerDto.getName());
            customer.setEmail(customerDto.getEmail());
            customer.setGender(customerDto.getGender());
            customer.setProducts(customerDto.getProducts());
            customerRepository.save(customerMapper.mapCustomerDtoToEntity(customer));
        } else {
            System.out.println("Customer Not Found!");
        }
    }

    @Override
    public List<CustomerDto> findByProduct(String productName) {
        List<Customer> customers = customerRepository.findByproducts_prodName(productName);
        return customers.stream().map(customerMapper::mapCustomerEntityToDto).collect(Collectors.toList());
    }

    @Override
    public List<CustomerDto> findByGender(String gender) {
        List<Customer> customers = customerRepository.findBygender(gender);
        return customers.stream().map(customerMapper::mapCustomerEntityToDto).collect(Collectors.toList());
    }


//    @Override
//    public List<OrderQueryNamesDto> findCustomerProductNames() {
//        List<OrderQueryNames> orderQueryNames = customerRepository.getCustomerProductName();
//        return orderQueryNames.stream().map(customerMapper::mapOrderQueryNamesEntityToDto).collect(Collectors.toList());
//    }

}
