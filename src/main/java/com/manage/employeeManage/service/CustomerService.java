package com.manage.employeeManage.service;

import com.manage.employeeManage.dto.CustomerDto;
import com.manage.employeeManage.dto.response.CustomerResponse;
import com.manage.employeeManage.entity.Customer;

import java.util.Optional;

public interface CustomerService {
    public CustomerResponse addCustomer(CustomerDto customerDto);
    public Optional<Customer> searchCustomerByUserName(String username);

    public String updateCustomerDetails(int id, CustomerDto customerDto);

    public String deleteCustomerById(int id);

}
