package com.manage.employeeManage.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
public class Customer{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id",length = 100,nullable = false)
    private int customerId;
    @Column(name = "customer_username",length = 1000,nullable = false, unique = true)
    private String customerUsername;
    @Column(name = "customer_password",length = 100,nullable = false)
    private String customerPassword;
    @Column(name = "customer_deleted", nullable = false)
    private boolean CustomerDeleted=false;
    @Column(name = "customer_modified_datetime")
    private LocalDateTime customerModifiedDateTime;
    @Column(name = "customer_created_datetime")
    private LocalDateTime customerCreatedDateTime;
    @Column(name = "customer_phone_number")
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salary_id")
    private Salary salary;


}
