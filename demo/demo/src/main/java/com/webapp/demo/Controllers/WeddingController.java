package com.webapp.demo.Controllers;

import com.webapp.demo.Model.IndoorWedding;
import com.webapp.demo.Model.OutdoorWedding;
import com.webapp.demo.Model.Wedding;
import com.webapp.demo.Service.WeddingService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("weddings")
public class WeddingController {

    private final WeddingService weddingService;
    private int nextId = 1;


    public WeddingController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }

    //read all weddings
    @GetMapping
    public List<Wedding> getListOfWedding() {
        return weddingService.getAllWedding();
    }

    //create a new wedding
    @PostMapping
    public Wedding createWedding(@RequestBody Wedding wedding) {
        wedding.setClientId(nextId++);
        weddingService.saveWedding(wedding);
        return wedding;
    }

    @GetMapping("/{id}")
    public Wedding getWeddingById(@PathVariable int id) {
        Wedding wedding = weddingService.getAllWedding().get(id);
        if (wedding == null) {
            throw new RuntimeException("Wedding not found with id: " + id);
        }
        return wedding;
    }

    //

    @PostMapping("/indoor")
    public IndoorWedding createIndoorWedding(@RequestBody IndoorWedding wedding) {
        wedding.setClientId(nextId++);
        weddingService.saveWedding(wedding);
        return wedding;
    }

    @PostMapping("/outdoor")
    public OutdoorWedding createOutdoorWedding(@RequestBody OutdoorWedding wedding) {
        wedding.setClientId(nextId++);
        weddingService.saveWedding(wedding);
        return wedding;
    }

    //

    @GetMapping("/type/{type}")
    public List<Wedding> getWeddingsByType(@PathVariable String type) {
        List<Wedding> result = new ArrayList<>();
        boolean isIndoor = type.equalsIgnoreCase("indoor");

        for (Wedding wedding : weddingService.getAllWedding()) {
            if (isIndoor && wedding instanceof IndoorWedding) {
                result.add(wedding);
            } else if (!isIndoor && wedding instanceof OutdoorWedding) {
                result.add(wedding);
            }
        }

        return result;
    }



    //

    @PutMapping("/{Id}")
    public Optional<Wedding> updateWedding(@RequestBody Wedding wedding, @PathVariable int id) {
        return weddingService.updateWedding(id, wedding);
    }

    @DeleteMapping("/{Id}")
    public boolean deleteWedding(@PathVariable int Id) {
        return weddingService.deleteWedding(Id);
    }



}
















