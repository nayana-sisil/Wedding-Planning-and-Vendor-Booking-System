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
@CrossOrigin
@RequestMapping("/api/vendors")

//

public class VendorController {

    @Autowired
    private VendorService service;

    //

    @PostMapping
    public String addVendor(@RequestBody Vendor vendor) {
        service.addVendor(vendor);
        return "Vendor added successfully!";
    }

    //

    @GetMapping
    public List<Vendor> getVendors() {
        return service.getAllVendors();
    }

    //

    @PutMapping("/{id}")
    public String updateVendor(@PathVariable("id") int id, @RequestBody Vendor vendor) {
        service.updateVendor(id, vendor);
        return "Vendor updated successfully!";
    }


    //

    @DeleteMapping("/{id}")
    public String deleteVendor(@PathVariable("id") int id) {
        service.deleteVendor(id);
        return "Vendor deleted successfully!";
    }

}
