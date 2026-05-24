package com.grievance.grievance_system.controller;

import com.grievance.grievance_system.model.Complaint;
import com.grievance.grievance_system.model.User;
import com.grievance.grievance_system.repository.ComplaintRepository;
import com.grievance.grievance_system.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/complaints")
public class ComplaintController {

    @Autowired
    private ComplaintRepository complaintRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/submit/{userId}")
    public Complaint submit(@PathVariable Long userId, @RequestBody Complaint complaint) {
        User user = userRepository.findById(userId).orElse(null);
        complaint.setUser(user);
        return complaintRepository.save(complaint);
    }

    @GetMapping("/all")
    public List<Complaint> getAllComplaints() {
        return complaintRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Complaint> getUserComplaints(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return complaintRepository.findByUser(user);
    }

    @PutMapping("/status/{id}")
    public Complaint updateStatus(@PathVariable Long id, @RequestParam String status) {
        Complaint complaint = complaintRepository.findById(id).orElse(null);
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }
}