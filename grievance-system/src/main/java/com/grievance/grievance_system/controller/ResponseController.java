package com.grievance.grievance_system.controller;

import com.grievance.grievance_system.model.Complaint;
import com.grievance.grievance_system.model.Response;
import com.grievance.grievance_system.repository.ComplaintRepository;
import com.grievance.grievance_system.repository.ResponseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/responses")
public class ResponseController {

    @Autowired
    private ResponseRepository responseRepository;

    @Autowired
    private ComplaintRepository complaintRepository;

    @PostMapping("/add/{complaintId}")
    public Response addResponse(@PathVariable Long complaintId, @RequestBody Response response) {
        Complaint complaint = complaintRepository.findById(complaintId).orElse(null);
        response.setComplaint(complaint);
        return responseRepository.save(response);
    }
}