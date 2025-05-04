package com.vendor.vendormanagement.service;

//

import com.vendor.vendormanagement.model.Vendor;
import org.springframework.stereotype.Service;

//

import java.io.*;
import java.util.ArrayList;
import java.util.List;

//

@Service
public class VendorService {
    private final String FILE_PATH = "vendors.txt";

    //

    public void addVendor(Vendor vendor) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(vendor.getId() + "," + vendor.getName() + "," +
                    vendor.getServiceType() + "," + vendor.getPrice());
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //

    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Vendor vendor = new Vendor(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2],
                        Double.parseDouble(parts[3])
                );
                vendors.add(vendor);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendors;
    }

    //

    public Vendor getVendorById(int id) {
        return getAllVendors().stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //

    public boolean updateVendor(int id, Vendor updatedVendor) {
        List<Vendor> vendors = getAllVendors();
        boolean updated = false;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Vendor v : vendors) {
                if (v.getId() == id) {
                    writer.write(updatedVendor.getId() + "," + updatedVendor.getName() + "," +
                            updatedVendor.getServiceType() + "," + updatedVendor.getPrice());
                    updated = true;
                } else {
                    writer.write(v.getId() + "," + v.getName() + "," +
                            v.getServiceType() + "," + v.getPrice());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return updated;
    }

    //
    
    public boolean deleteVendor(int id) {
        List<Vendor> vendors = getAllVendors();
        boolean deleted = vendors.removeIf(v -> v.getId() == id);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Vendor v : vendors) {
                writer.write(v.getId() + "," + v.getName() + "," +
                        v.getServiceType() + "," + v.getPrice());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
