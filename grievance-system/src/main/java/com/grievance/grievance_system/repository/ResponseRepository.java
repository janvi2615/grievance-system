package com.grievance.grievance_system.repository;

import com.grievance.grievance_system.model.Response;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResponseRepository extends JpaRepository<Response, Long> {
}