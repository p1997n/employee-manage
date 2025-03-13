package com.manage.employeeManage.service.impl;

import com.manage.employeeManage.dto.CustomerDto;
import com.manage.employeeManage.entity.Customer;
import com.manage.employeeManage.repo.CustomerRepo;
import com.manage.employeeManage.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepo customerRepo;

    public String addCustomer(CustomerDto customerDto){

        Customer customer = new Customer(customerDto.getCustomerId(),customerDto.getCustomerUsername(),customerDto.getCustomerPassword(),customerDto.isCustomerDeleted());
        if(customerRepo.existsByCustomerUsername(customerDto.getCustomerUsername())){
            return customerDto.getCustomerUsername()  + " Customer Already exist in System";
        }else{
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
