package com.vendor.vendormanagement.controller;

//

import com.vendor.vendormanagement.model.Vendor;
import com.vendor.vendormanagement.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//

import java.util.List;

//

@RestController
@RequestMapping("/api/vendors")

//

public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @PostMapping
    public Vendor addVendor(@RequestBody Vendor vendor) {
        return vendorService.addVendor(vendor);
    }
}
