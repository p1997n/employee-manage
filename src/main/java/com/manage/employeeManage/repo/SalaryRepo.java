package com.manage.employeeManage.repo;


import com.manage.employeeManage.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface SalaryRepo extends JpaRepository<Salary,Integer> {
}
