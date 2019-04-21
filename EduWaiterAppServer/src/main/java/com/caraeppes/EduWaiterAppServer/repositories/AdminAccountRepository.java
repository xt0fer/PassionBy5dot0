package com.caraeppes.EduWaiterAppServer.repositories;

import com.caraeppes.EduWaiterAppServer.models.AdminAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminAccountRepository extends JpaRepository<AdminAccount, Long> {

    AdminAccount findAdminAccountByUsername(String username);
}

