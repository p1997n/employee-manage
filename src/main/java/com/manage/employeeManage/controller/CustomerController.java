package com.manage.employeeManage.controller;


import com.manage.employeeManage.dto.CustomerDto;
import com.manage.employeeManage.dto.SalaryDto;
import com.manage.employeeManage.entity.Customer;
import com.manage.employeeManage.dto.response.CustomerResponse;
import com.manage.employeeManage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(path = "/add-customer")
    public String addCustomer(@RequestBody CustomerDto customerDto, SalaryDto salaryDto){
        String customerSaved = customerService.addCustomer(customerDto,salaryDto);
        return customerSaved;
    }

//    @GetMapping(path = "/search-customer")
//    public ResponseEntity<Customer> searchCustomerByUsername(@RequestParam String username){
//        Optional<Customer> customer = customerService.searchCustomerByUserName(username);
//        if(customer.isPresent()){
//            return ResponseEntity.ok(customer.get());
//        }else{
//            return ResponseEntity.notFound().build();
//        }
//
//    }

    @GetMapping(path = "/search-customer")
    public CustomerResponse searchCustomerByUserName(@RequestParam String username){
        Optional<Customer> customer = customerService.searchCustomerByUserName(username);
        if(customer.isPresent()) {
            CustomerResponse searchCustomer = new CustomerResponse(customer.get(),200);
            return searchCustomer;
        }else{
            return new CustomerResponse("Customer doesn't exist",400);
        }

    }

    @PutMapping(path = "/{id}")
    public String updateCustomer(@PathVariable int id, @RequestBody CustomerDto customerDto){
       return customerService.updateCustomerDetails(id,customerDto);
    }

    @PutMapping(path = "customer-delete/{id}")
    public String deleteCustomer(@PathVariable int id){
        return customerService.deleteCustomerById(id);
    }

}
