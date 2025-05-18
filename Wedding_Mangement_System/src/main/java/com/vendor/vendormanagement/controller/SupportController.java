package com.vendor.vendormanagement.controller;


import com.vendor.vendormanagement.model.Support;
import com.vendor.vendormanagement.service.SupportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/support")
@CrossOrigin(origins = "*") // Enable CORS if frontend is separate
public class SupportController {

    @Autowired
    private SupportService service;

    // POST: Submit support message
    @PostMapping
    public void submit(@RequestBody Support support) {
        service.submitSupportRequest(support);  // ✅ Correct method name
    }

    // GET: Retrieve all support requests
    @GetMapping
    public List<Support> getAll() {
        return service.getAllSupportRequests();  // or use filtering if needed
    }
}

