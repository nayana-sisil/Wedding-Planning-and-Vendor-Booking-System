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
public class VendorController {

    @Autowired
    private VendorService vendorService;

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable int id) {
        return vendorService.getVendorById(id);
    }

    @PostMapping
    public void addVendor(@RequestBody Vendor vendor) {
        vendorService.addVendor(vendor);
    }

    @PutMapping("/{id}")
    public boolean updateVendor(@PathVariable int id, @RequestBody Vendor vendor) {
        return vendorService.updateVendor(id, vendor);
    }

    @DeleteMapping("/{id}")
    public boolean deleteVendor(@PathVariable int id) {
        return vendorService.deleteVendor(id);
    }
}
