package com.manage.employeeManage.repo;


import com.manage.employeeManage.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
    boolean existsByCustomerUsername(String username);

    Optional<Customer> findByCustomerUsername(String username);

    @Modifying
    @Transactional
    @Query("UPDATE Customer SET CustomerDeleted = true, customerUsername = CONCAT('Del_',customerUsername)   WHERE customerId = :id")
    int customerSoftDel(@Param("id") int id);
}
