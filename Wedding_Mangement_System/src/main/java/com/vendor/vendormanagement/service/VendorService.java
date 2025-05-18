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
            writer.write(vendor.getId() + "," +
                    vendor.getName() + "," +
                    vendor.getServiceType() + "," +
                    vendor.getPrice() + "," +
                    vendor.getContact() + "," +
                    (vendor.getDistrict() != null ? vendor.getDistrict() : "") + "," +
                    (vendor.getCountry() != null ? vendor.getCountry() : "") + "," +
                    (vendor.getTravelCost() != null ? vendor.getTravelCost() : ""));
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
                if (parts.length >= 5) {
                    int id = Integer.parseInt(parts[0]);
                    String name = parts[1];
                    String serviceType = parts[2];
                    double price = Double.parseDouble(parts[3]);
                    String contact = parts[4];

                    Vendor vendor = new Vendor(id, name, serviceType, price, contact);

                    if (parts.length >= 6) vendor.setDistrict(parts[5]);
                    if (parts.length >= 7) vendor.setCountry(parts[6]);
                    if (parts.length >= 8) {
                        try {
                            vendor.setTravelCost(Double.parseDouble(parts[7]));
                        } catch (NumberFormatException e) {
                            vendor.setTravelCost(0.0);
                        }
                    }

                    vendors.add(vendor);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return vendors;
    }

    //

    public void updateVendor(int id, Vendor updatedVendor) {
        List<Vendor> vendors = getAllVendors();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Vendor v : vendors) {
                if (v.getId() == id) {
                    // Update only if new data is provided
                    if (updatedVendor.getName() != null && !updatedVendor.getName().isEmpty()) {
                        v.setName(updatedVendor.getName());
                    }
                    if (updatedVendor.getServiceType() != null && !updatedVendor.getServiceType().isEmpty()) {
                        v.setServiceType(updatedVendor.getServiceType());
                    }
                    if (updatedVendor.getPrice() != 0) {
                        v.setPrice(updatedVendor.getPrice());
                    }
                    if (updatedVendor.getContact() != null && !updatedVendor.getContact().isEmpty()) {
                        v.setContact(updatedVendor.getContact());
                    }
                    if (updatedVendor.getDistrict() != null && !updatedVendor.getDistrict().isEmpty()) {
                        v.setDistrict(updatedVendor.getDistrict());
                    }
                    if (updatedVendor.getCountry() != null && !updatedVendor.getCountry().isEmpty()) {
                        v.setCountry(updatedVendor.getCountry());
                    }
                    if (updatedVendor.getTravelCost() != null && updatedVendor.getTravelCost() > 0) {
                        v.setTravelCost(updatedVendor.getTravelCost());
                    }
                }

                writer.write(v.getId() + "," +
                        v.getName() + "," +
                        v.getServiceType() + "," +
                        v.getPrice() + "," +
                        v.getContact() + "," +
                        (v.getDistrict() != null ? v.getDistrict() : "") + "," +
                        (v.getCountry() != null ? v.getCountry() : "") + "," +
                        (v.getTravelCost() != null ? v.getTravelCost() : ""));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //

    public void deleteVendor(int id) {
        List<Vendor> vendors = getAllVendors();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Vendor v : vendors) {
                if (v.getId() != id) {
                    writer.write(v.getId() + "," +
                            v.getName() + "," +
                            v.getServiceType() + "," +
                            v.getPrice() + "," +
                            v.getContact() + "," +
                            (v.getDistrict() != null ? v.getDistrict() : "") + "," +
                            (v.getCountry() != null ? v.getCountry() : "") + "," +
                            (v.getTravelCost() != null ? v.getTravelCost() : ""));
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
