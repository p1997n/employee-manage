package com.manage.employeeManage.service;

import com.manage.employeeManage.dto.AdminDto;

public interface AdminService {
    public String addAdmin(AdminDto adminDto);
    public boolean authenticateAdmin(String username, String password);
}
