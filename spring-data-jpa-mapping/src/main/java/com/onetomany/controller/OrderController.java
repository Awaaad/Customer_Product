package com.onetomany.controller;

import com.onetomany.dto.CustomerDto;
import com.onetomany.dto.OrderQueryNamesDto;
import com.onetomany.repository.CustomerRepository;
import com.onetomany.service.ProductService;
import com.onetomany.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", maxAge = 10000)
@RequestMapping("/order")
public class OrderController {
    private final CustomerService customerService;
    private final CustomerRepository customerRepository;

    public OrderController(CustomerService customerService, CustomerRepository customerRepository, ProductService productService) {
        this.customerService = customerService;
        this.customerRepository = customerRepository;
    }


    //  GET GOES HERE:
    @GetMapping("/getCustomerProduct")
    public List<OrderQueryNamesDto> getCustomerProductName(){
        return customerService.findCustomerProductNames();
    }

    @PostMapping("/saveOrder")
    public ResponseEntity placeOrder(@RequestBody CustomerDto customerDto){
        customerService.saveCustomer(customerDto);
        return new ResponseEntity("Order saved successfully!",HttpStatus.OK);
    }

//    @PostMapping("/save")
//    @ResponseBody
//    public ResponseEntity<String> saveOrder(@RequestBody Customer customer){
//        customerRepository.save(customer);
//        return new ResponseEntity<String>("Order saved successfully!",HttpStatus.OK);
//    }

    //  DELETE GOES HERE:

}
