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
        adminService.addAdmin(adminDto);
        return "Saved";
    }
}
