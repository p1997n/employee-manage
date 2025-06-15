package com.manage.employeeManage.util;

import org.springframework.stereotype.Component;

@Component
public class InputValidator {

    public boolean validateCustomerName(String name){
        if(name==null || name.isEmpty() || name.length()<3 || name.length()>10){
            return true;
        }
        return false;
    }
    public boolean validatePhoneNumber(String phoneNumber){
        if(phoneNumber==null || !phoneNumber.matches("^\\+94[0-9]{9}$")){
            return true;
        }
        return false;

    }

}
