package com.caraeppes.EduWaiterAppServer.repositories;

import com.caraeppes.EduWaiterAppServer.models.EmployeeAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAccountRepository extends JpaRepository<EmployeeAccount, Long> {

    EmployeeAccount findByUsername(String username);
}
