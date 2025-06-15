package com.manage.employeeManage.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerAddRequest {
    private String customerUsername;
    private String customerPassword;
    private double salaryBasic;
    private double salaryAllowance;
    private double salaryEpf;
    private double salaryEtf;
    private double salaryTax;

}
