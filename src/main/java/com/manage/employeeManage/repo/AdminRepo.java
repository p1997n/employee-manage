package com.manage.employeeManage.repo;

import com.manage.employeeManage.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface AdminRepo extends JpaRepository<Admin,Integer> {

}
