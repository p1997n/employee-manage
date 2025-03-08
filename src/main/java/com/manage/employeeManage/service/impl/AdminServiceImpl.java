package com.manage.employeeManage.service.impl;

import com.manage.employeeManage.dto.AdminDto;
import com.manage.employeeManage.entity.Admin;
import com.manage.employeeManage.repo.AdminRepo;
import com.manage.employeeManage.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;
    public String addAdmin(AdminDto adminDto){
        Admin admin = new Admin(adminDto.getAdminId(),adminDto.getAdminUsername(),adminDto.getAdminPassword());
        if(adminRepo.existsById(adminDto.getAdminId())){
            return "Already Exist";
        }else{
            adminRepo.save(admin);
            return "Admin saved";
        }
    }

}
