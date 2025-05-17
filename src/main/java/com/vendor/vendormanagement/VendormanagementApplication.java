package com.vendor.vendormanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class VendormanagementApplication {
    public static void main(String[] args) {
        SpringApplication.run(VendormanagementApplication.class, args);
    }
}
