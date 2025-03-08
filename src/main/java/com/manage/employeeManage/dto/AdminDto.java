package com.manage.employeeManage.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AdminDto {
    private int adminId;
    private String adminUsername;
    private String adminPassword;



}
