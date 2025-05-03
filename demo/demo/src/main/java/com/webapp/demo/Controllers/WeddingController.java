package com.webapp.demo.Controllers;

import com.webapp.demo.Model.IndoorWedding;
import com.webapp.demo.Model.OutdoorWedding;
import com.webapp.demo.Model.Wedding;
import com.webapp.demo.Service.WeddingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/weddings")
public class WeddingController {

    private final WeddingService weddingService;

    public WeddingController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }

    // Get all weddings
    @GetMapping
    public ResponseEntity<List<Wedding>> getAllWeddings() {
        List<Wedding> weddings = weddingService.getAllWedding();
        return new ResponseEntity<>(weddings, HttpStatus.OK);
    }

    // Get a wedding by clientId
    @GetMapping("/{clientId}")
    public ResponseEntity<Wedding> getWeddingById(@PathVariable int clientId) {
        List<Wedding> weddings = weddingService.getAllWedding();
        for (Wedding wedding : weddings) {
            if (wedding.getClientId() == clientId) {
                return new ResponseEntity<>(wedding, HttpStatus.OK);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    // Create a new wedding
    @PostMapping
    public ResponseEntity<Wedding> createWedding(@RequestBody Wedding wedding) {
        Optional<Wedding> savedWedding = weddingService.saveWedding(wedding);
        if (savedWedding.isPresent()) {
            return new ResponseEntity<>(savedWedding.get(), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    // Get weddings by type (indoor or outdoor)
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

    // Update a wedding
    @PutMapping("/{clientId}")
    public ResponseEntity<Wedding> updateWedding(@PathVariable int clientId, @RequestBody Wedding wedding) {
        Optional<Wedding> updatedWedding = weddingService.updateWedding(clientId, wedding);
        if (updatedWedding.isPresent()) {
            return new ResponseEntity<>(updatedWedding.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete a wedding
    @DeleteMapping("/{clientId}")
    public ResponseEntity<String> deleteWedding(@PathVariable int clientId) {
        boolean deleted = weddingService.deleteWedding(clientId);
        if (deleted) {
            return new ResponseEntity<>("Wedding deleted successfully", HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>("Wedding not found", HttpStatus.NOT_FOUND);
        }
    }
}