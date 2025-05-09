package com.vendor.vendormanagement.service;

import com.vendor.vendormanagement.model.Vendor;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendorService {
    private final String FILE_PATH = "vendors.txt";

    public boolean addVendor(Vendor newVendor) {
        List<Vendor> existingVendors = getAllVendors();
        for (Vendor v : existingVendors) {
            if (v.getId() == newVendor.getId()) {
                return false; // ID already exists
            }
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(newVendor.getId() + "," + newVendor.getName() + "," +
                    newVendor.getServiceType() + "," + newVendor.getPrice() + "," +
                    newVendor.getContact());
            writer.newLine();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Vendor> getAllVendors() {
        List<Vendor> vendors = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length != 5) continue;
                try {
                    int id = Integer.parseInt(parts[0].trim());
                    String name = parts[1].trim();
                    String service = parts[2].trim();
                    double price = Double.parseDouble(parts[3].trim());
                    String contact = parts[4].trim();
                    vendors.add(new Vendor(id, name, service, price, contact));
                } catch (NumberFormatException e) {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendors;
    }

    public List<Vendor> searchVendorsByName(String name) {
        List<Vendor> result = new ArrayList<>();
        for (Vendor v : getAllVendors()) {
            if (v.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(v);
            }
        }
        return result;
    }

    public List<Vendor> searchVendorsByServiceType(String serviceType) {
        List<Vendor> result = new ArrayList<>();
        for (Vendor v : getAllVendors()) {
            if (v.getServiceType().toLowerCase().contains(serviceType.toLowerCase())) {
                result.add(v);
            }
        }
        return result;
    }

    public Vendor getVendorById(int id) {
        return getAllVendors().stream()
                .filter(v -> v.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean updateVendor(int id, Vendor updatedVendor) {
        List<Vendor> vendors = getAllVendors();
        boolean updated = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Vendor v : vendors) {
                if (v.getId() == id) {
                    writer.write(updatedVendor.getId() + "," + updatedVendor.getName() + "," +
                            updatedVendor.getServiceType() + "," + updatedVendor.getPrice() + "," +
                            updatedVendor.getContact());
                    updated = true;
                } else {
                    writer.write(v.getId() + "," + v.getName() + "," +
                            v.getServiceType() + "," + v.getPrice() + "," + v.getContact());
                }
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return updated;
    }

    public boolean deleteVendor(int id) {
        List<Vendor> vendors = getAllVendors();
        boolean deleted = vendors.removeIf(v -> v.getId() == id);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Vendor v : vendors) {
                writer.write(v.getId() + "," + v.getName() + "," +
                        v.getServiceType() + "," + v.getPrice() + "," + v.getContact());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return deleted;
    }
}
