package com.manage.employeeManage.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto{
    private int customerId;
    private String customerUsername;
    private String customerPassword;
    private boolean CustomerDeleted=false;
}
