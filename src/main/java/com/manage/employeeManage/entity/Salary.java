package com.manage.employeeManage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "employee_salary")
public class Salary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salary_id",length = 100,nullable = false)
    private int salaryId;
    @Column(name = "salary_basic",length = 100)
    private double salaryBasic;
    @Column(name = "salary_allowance",length = 100)
    private double salaryAllowance;
    @Column(name = "salary_etf",length = 100)
    private double salaryEpf;
    @Column(name = "salary_epf",length = 100)
    private double salaryEtf;
    @Column(name = "salary_tax",length = 100)
    private double salaryTax;
    @Column(name = "salary_update_date")
    private LocalDateTime salaryUpdateDate;
}
