package com.manage.employeeManage.service.impl;

import com.manage.employeeManage.dto.CustomerDto;
import com.manage.employeeManage.dto.response.CustomerResponse;
import com.manage.employeeManage.entity.Customer;
import com.manage.employeeManage.entity.Salary;
import com.manage.employeeManage.repo.CustomerRepo;
import com.manage.employeeManage.repo.SalaryRepo;
import com.manage.employeeManage.service.CustomerService;
import com.manage.employeeManage.util.InputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private SalaryRepo salaryRepo;

    @Autowired
    InputValidator inputValidator;


    public CustomerResponse addCustomer(CustomerDto customerDto){
        if(customerRepo.existsByCustomerUsername(customerDto.getCustomerUsername())){
            return new CustomerResponse(400,"Customer already exists");
        }else if(inputValidator.validateCustomerName(customerDto.getCustomerUsername())) {
            return new CustomerResponse(101, "Name must be between 3 and 10 characters");
        }else if(inputValidator.validatePhoneNumber(customerDto.getPhoneNumber())){
            return new CustomerResponse(102,"Phone number is invalid");
        }else{
            Salary salary = new Salary();
            salary.setSalaryBasic(customerDto.getSalary().getSalaryBasic());
            salary.setSalaryAllowance(customerDto.getSalary().getSalaryAllowance());
            salary.setSalaryUpdateDate(LocalDateTime.now());
            salary.setSalaryEpf(customerDto.getSalary().getSalaryEpf());
            salary.setSalaryEtf(customerDto.getSalary().getSalaryEtf());
            salary.setSalaryTax(customerDto.getSalary().getSalaryTax());
            salaryRepo.save(salary);
            Customer customer = new Customer();
            customer.setCustomerUsername(customerDto.getCustomerUsername());
            customer.setCustomerPassword(customerDto.getCustomerPassword());
            customer.setCustomerCreatedDateTime(LocalDateTime.now());
            customer.setPhoneNumber(customerDto.getPhoneNumber());
            customer.setSalary(salary);
            customerRepo.save(customer);
            return new CustomerResponse(201,"Customer added successfully");
        }
    }

    public Optional<Customer> searchCustomerByUserName(String username){
        Optional<Customer> customer = customerRepo.findByCustomerUsername(username);
        return customer;
    }

    public String updateCustomerDetails(int id, CustomerDto customerDto){
        Optional<Customer> customer = customerRepo.findById(id);
        if (customer.isPresent() && !customer.get().isCustomerDeleted()) {
            customer.get().setCustomerPassword(customerDto.getCustomerPassword());
            customer.get().setCustomerModifiedDateTime(LocalDateTime.now());
            customer.get().setPhoneNumber( customerDto.getPhoneNumber());
            Salary salary = customer.get().getSalary();
            salary.setSalaryBasic(customerDto.getSalary().getSalaryBasic());
            salary.setSalaryAllowance(customerDto.getSalary().getSalaryAllowance());
            salary.setSalaryEpf(customerDto.getSalary().getSalaryEpf());
            salary.setSalaryEtf(customerDto.getSalary().getSalaryEtf());
            salary.setSalaryTax(customerDto.getSalary().getSalaryTax());
            salary.setSalaryUpdateDate(LocalDateTime.now());
            salaryRepo.save(salary);
            customerRepo.save(customer.get());
            return "Customer updated successfully";

        } else {
            return "Customer not found";
        }

    }

    @Override
    @Transactional
    public String deleteCustomerById(int id){
        Optional<Customer> customer = customerRepo.findById(id);
        if(!(customer.isPresent() & !customer.get().isCustomerDeleted())){
            return "Customer doesn't exist";
        }else{
            customerRepo.customerSoftDel(id);
            return "Customer deleted successfully";
        }

    }
}
