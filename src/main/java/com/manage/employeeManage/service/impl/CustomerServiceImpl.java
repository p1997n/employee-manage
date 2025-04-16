package com.manage.employeeManage.service.impl;

import com.manage.employeeManage.dto.CustomerDto;
import com.manage.employeeManage.dto.SalaryDto;
import com.manage.employeeManage.entity.Customer;
import com.manage.employeeManage.entity.Salary;
import com.manage.employeeManage.repo.CustomerRepo;
import com.manage.employeeManage.repo.SalaryRepo;
import com.manage.employeeManage.service.CustomerService;
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

    public String addCustomer(CustomerDto customerDto, SalaryDto salaryDto){

        if(customerRepo.existsByCustomerUsername(customerDto.getCustomerUsername())){
            return customerDto.getCustomerUsername()  + " Customer Already exist in System";
        }else{
            Customer customer = new Customer();
            customer.setCustomerId(customerDto.getCustomerId());
            customer.setCustomerDeleted(customerDto.isCustomerDeleted());
            customer.setCustomerUsername(customerDto.getCustomerUsername());
            customer.setCustomerPassword(customerDto.getCustomerPassword());
            customer.setCustomerCreatedDateTime(customerDto.getCustomerCreatedDateTime());
            customer.setCustomerModifiedDateTime(customerDto.getCustomerModifiedDateTime());
            if(customerDto.getSalaryId()==salaryDto.getSalaryId()) {
                Salary salary = new Salary();
                salary.setSalaryBasic(salaryDto.getSalaryBasic());
                salary.setSalaryAllowance(salaryDto.getSalaryAllowance());
                salary.setSalaryEpf(salaryDto.getSalaryEpf());
                salary.setSalaryEtf(salaryDto.getSalaryEtf());
                salary.setSalaryId(salaryDto.getSalaryId());
                salary.setSalaryTax(salaryDto.getSalaryTax());
                customer.setSalary(salary);
                salary.setCustomer(customer);
                salaryRepo.save(salary);
            }

            customerRepo.save(customer);
            return customerDto.getCustomerUsername() +" Customer Saved Successfully!";
        }


    }

    public Optional<Customer> searchCustomerByUserName(String username){
        return  customerRepo.findByCustomerUsername(username);
    }

    public String updateCustomerDetails(int id, CustomerDto customerDto){
        if(customerRepo.existsById(id)){
            Customer customer = customerRepo.getById(id);
            if((customer.getCustomerUsername()).equals(customerDto.getCustomerUsername())){
                customer.setCustomerPassword(customerDto.getCustomerPassword());
                customer.setCustomerModifiedDateTime(LocalDateTime.now());
                customerRepo.save(customer);
                return id + " Updated Successfully!";
            }else{
                return "Customer "+id +" and " + customerDto.getCustomerUsername() + " does not match";
            }

        }else{
            return id + " Customer Does Not exist system!";
        }

    }

    @Override
    @Transactional
    public String deleteCustomerById(int id){
        if(customerRepo.existsById(id)){
            customerRepo.customerSoftDel(id);
            return "Customer Deleted";
        }else{
            return "Customer doesn't exist";
        }

    }
}
