package com.vendor.vendormanagement.repository;

import com.vendor.vendormanagement.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendorRepository extends JpaRepository<Vendor, Long> {
}
