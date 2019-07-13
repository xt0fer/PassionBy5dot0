package com.caraeppes.EduWaiterAppServer.repositories;

import com.caraeppes.EduWaiterAppServer.models.MenuItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItem, Long> {
}
