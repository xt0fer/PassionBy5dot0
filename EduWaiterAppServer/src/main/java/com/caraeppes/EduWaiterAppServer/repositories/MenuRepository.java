package com.caraeppes.EduWaiterAppServer.repositories;

import com.caraeppes.EduWaiterAppServer.models.Menu;
import com.caraeppes.EduWaiterAppServer.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {}
