package com.manage.employeeManage.service;

import com.manage.employeeManage.dto.CustomerDto;
import com.manage.employeeManage.dto.SalaryDto;
import com.manage.employeeManage.entity.Customer;

import java.util.Optional;

public interface CustomerService {
    public String addCustomer(CustomerDto customerDto, SalaryDto salaryDto);
    public Optional<Customer> searchCustomerByUserName(String username);

    public String updateCustomerDetails(int id, CustomerDto customerDto);

    public String deleteCustomerById(int id);

}
