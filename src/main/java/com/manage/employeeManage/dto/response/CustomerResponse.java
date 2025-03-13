package com.manage.employeeManage.dto.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.manage.employeeManage.entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@JsonRootName("response")

public class CustomerResponse{
    private Customer customer;
    private String message;
    private int code;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public CustomerResponse(Customer customer, int code) {
        this.customer = customer;
        this.code = code;
    }

    public CustomerResponse(String message, int code) {
        this.message = message;
        this.code = code;
    }
}
