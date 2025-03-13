package com.manage.employeeManage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "admin")
public class Admin {
    @Id
    @Column(name = "admin_id",length = 10)
    private int adminId;
    @Column(name = "admin_username",length = 200,nullable = false,unique = true)
    private String adminUsername;
    @Column(name = "admin_password",length = 100,nullable = false)
    private String adminPassword;


}
