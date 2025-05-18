package com.vendor.vendormanagement.controller;


import com.vendor.vendormanagement.model.IndoorWedding;
import com.vendor.vendormanagement.model.OutdoorWedding;
import com.vendor.vendormanagement.model.Wedding;
import com.vendor.vendormanagement.service.WeddingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//
 //
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/weddings")
public class WeddingController {

    private final WeddingService weddingService;

    public WeddingController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }




    //



    @GetMapping
    public ResponseEntity<List<Wedding>> getAllWeddings() {
        List<Wedding> weddings = weddingService.getAllWedding();
        return new ResponseEntity<>(weddings, HttpStatus.OK);
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Wedding> getWeddingById(@PathVariable("clientId") int clientId) {
        List<Wedding> weddings = weddingService.getAllWedding();
        for (Wedding wedding : weddings) {
            if (wedding.getClientId() == clientId) {
                return new ResponseEntity<>(wedding, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    //


    @PostMapping
    public ResponseEntity<Wedding> createWedding(@RequestBody Wedding wedding) {
        Optional<Wedding> savedWedding = weddingService.saveWedding(wedding);
        return savedWedding
                .map(value -> new ResponseEntity<>(value, HttpStatus.CREATED))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Wedding>> getWeddingsByType(@PathVariable String type) {
        List<Wedding> weddings = weddingService.getAllWedding();
        List<Wedding> result = new ArrayList<>();
        boolean isIndoor = type.equalsIgnoreCase("indoor");

        for (Wedding wedding : weddings) {
            if (isIndoor && wedding instanceof IndoorWedding) {
                result.add(wedding);
            } else if (!isIndoor && wedding instanceof OutdoorWedding) {
                result.add(wedding);
            }
        }
        return new ResponseEntity<>(result, HttpStatus.OK);
    }


    //


    @PutMapping("/{clientId}")
    public ResponseEntity<Wedding> updateWedding(@PathVariable("clientId") int clientId, @RequestBody Wedding wedding) {
        Optional<Wedding> updatedWedding = weddingService.updateWedding(clientId, wedding);
        return updatedWedding
                .map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteWedding(@PathVariable("clientId") int clientId) {
        boolean deleted = weddingService.deleteWedding(clientId);
        if (deleted) {
            return new ResponseEntity<>("Wedding deleted successfully", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Wedding not found", HttpStatus.NOT_FOUND);
        }
    }





}
