package com.manage.employeeManage.controller;

import com.manage.employeeManage.dto.AdminDto;
import com.manage.employeeManage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping(path = "/add-admin")
    public String addAdmin(@RequestBody AdminDto adminDto){
        String saveAdmin = adminService.addAdmin(adminDto);
        return saveAdmin;

    }

    @PostMapping(path = "/admin-login")
    public String logAdmin(@RequestBody AdminDto adminDto){
        boolean isAuthenticated = adminService.authenticateAdmin(adminDto.getAdminUsername(),adminDto.getAdminPassword());
        if(isAuthenticated){
            return "Login Successfully";
        }else{
            return "Incorrect username or password";
        }
    }

}
