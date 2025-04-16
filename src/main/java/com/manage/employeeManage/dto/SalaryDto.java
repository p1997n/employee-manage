package com.manage.employeeManage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {
    private int salaryId;
    private double salaryBasic;
    private double salaryAllowance;
    private double salaryEpf;
    private double salaryEtf;
    private double salaryTax;
    private LocalDateTime salaryUpdateDate;
    private int customerId;
}
