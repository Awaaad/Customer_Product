package com.onetomany.controller;

import com.onetomany.dto.CustomerDto;
import com.onetomany.entity.Customer;
import com.onetomany.repository.CustomerRepository;
import com.onetomany.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public CustomerController(CustomerService customerService, CustomerRepository customerRepository) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }

    // GET GOES HERE
    @GetMapping("all")
    public ResponseEntity<List<CustomerDto>> getAllCustomers(){
        return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("customerId/{customerId}")
    public ResponseEntity<CustomerDto>getByCustomerId(@PathVariable long customerId){
        return new ResponseEntity<>(customerService.findCustomerById(customerId), HttpStatus.OK);
    }

    @GetMapping("customerHasProduct/{prodName}")
    public ResponseEntity<List<CustomerDto>> getByProduct(@PathVariable String prodName){
        return new ResponseEntity<>(customerService.findByProduct(prodName), HttpStatus.OK);
    }

    @GetMapping("gender/{gender}")
    public ResponseEntity<List<CustomerDto>> getCustomerByGender(@PathVariable String gender){
        return new ResponseEntity<>(customerService.findByGender(gender), HttpStatus.OK);
    }

    // POST GOES HERE

    // PUT GOES HERE
    @PutMapping("editCustomer")
    public ResponseEntity editCustomer(@RequestBody CustomerDto customerDto){
        customerService.editCustomer(customerDto);
        return new ResponseEntity<String>("Customer edited successfully!",HttpStatus.OK);
    }


    // DELETE GOES HERE
    @DeleteMapping("deleteCustomer/{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable long customerId){
        customerService.deleteCustomer(customerId);
        return new ResponseEntity<String>("Customer deleted successfully!",HttpStatus.OK);
    }
}
