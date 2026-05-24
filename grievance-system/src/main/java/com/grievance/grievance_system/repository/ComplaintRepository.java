package com.grievance.grievance_system.repository;

import com.grievance.grievance_system.model.Complaint;
import com.grievance.grievance_system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ComplaintRepository extends JpaRepository<Complaint, Long> {
    List<Complaint> findByUser(User user);
}