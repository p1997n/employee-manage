package com.manage.employeeManage.dto;


import com.manage.employeeManage.entity.Salary;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto{
    private int customerId;
    private String customerUsername;
    private String customerPassword;
    private boolean customerDeleted=false;
    private LocalDateTime customerCreatedDateTime;
    private LocalDateTime customerModifiedDateTime;
    private int salaryId;
}
