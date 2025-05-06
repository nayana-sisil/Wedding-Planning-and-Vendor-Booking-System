package com.vendor.vendormanagement.controller;

//

import com.vendor.vendormanagement.model.Vendor;
import com.vendor.vendormanagement.service.VendorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//

import java.util.List;

//

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/vendors")
public class VendorController {

    @Autowired
    private VendorService vendorService;

    //

    @GetMapping
    public List<Vendor> getAllVendors() {
        return vendorService.getAllVendors();
    }

    @GetMapping("/{id}")
    public Vendor getVendorById(@PathVariable("id") int id) {
        return vendorService.getVendorById(id);
    }

    @GetMapping("/search/name/{name}")
    public List<Vendor> searchByName(@PathVariable("name") String name) {
        return vendorService.searchVendorsByName(name);
    }

    @GetMapping("/search/service/{serviceType}")
    public List<Vendor> searchByServiceType(@PathVariable("serviceType") String serviceType) {
        return vendorService.searchVendorsByServiceType(serviceType);
    }

    //

    @PostMapping
    public String addVendor(@RequestBody Vendor vendor) {
        boolean added = vendorService.addVendor(vendor);
        return added ? "Vendor added successfully." : "Vendor ID already exists!";
    }

    //

    @PutMapping("/{id}")
    public String updateVendor(@PathVariable("id") int id, @RequestBody Vendor vendor) {
        boolean updated = vendorService.updateVendor(id, vendor);
        return updated ? "Vendor updated successfully." : "Vendor not found!";
    }

    //

    @DeleteMapping("/{id}")
    public String deleteVendor(@PathVariable("id") int id) {
        boolean deleted = vendorService.deleteVendor(id);
        return deleted ? "Vendor deleted successfully." : "Vendor not found!";
    }
}
