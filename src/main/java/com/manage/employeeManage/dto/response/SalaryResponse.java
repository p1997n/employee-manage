package com.manage.employeeManage.dto.response;

import com.fasterxml.jackson.annotation.JsonRootName;
import com.manage.employeeManage.entity.Salary;

@JsonRootName("response")
public class SalaryResponse {
    private String message;
    private int code;
    private Salary salary;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
