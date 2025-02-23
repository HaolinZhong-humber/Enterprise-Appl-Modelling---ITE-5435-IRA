package com.assign4.repository;

import com.assign4.model.WorkshopRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkshopRegistrationRepo extends JpaRepository<WorkshopRegistration, Long> {
}
