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
    @Column(name="customer_createddatetime")
    private LocalDateTime customerCreatedDateTime;
    @Column(name = "customer_modifieddatetime")
    private LocalDateTime customerModifiedDateTime;
    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private Salary salary;

}
