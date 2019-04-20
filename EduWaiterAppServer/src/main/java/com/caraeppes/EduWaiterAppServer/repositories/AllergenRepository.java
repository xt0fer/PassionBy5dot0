package com.caraeppes.EduWaiterAppServer.repositories;

import com.caraeppes.EduWaiterAppServer.models.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AllergenRepository extends JpaRepository<Allergen, Long> {
}
