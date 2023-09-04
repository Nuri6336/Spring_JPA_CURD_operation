package com.nuri.bikesolution.controller;

import com.nuri.bikesolution.exception.CustomException;
import com.nuri.bikesolution.model.Bike;
import com.nuri.bikesolution.service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @GetMapping("/bike/all")
    public ResponseEntity<List<Bike>> getAllBikeInfo(){
        List<Bike> bikes = bikeService.getAllBike();
        return new ResponseEntity<>(bikes, HttpStatus.OK);
    }

    @GetMapping("/bike/info")
    public ResponseEntity<Bike> getOneBikeInfo(@RequestParam Integer id) throws CustomException {
        Optional<Bike> bikes = bikeService.getBikeByName(id);
        return new ResponseEntity<>(bikes.get(), HttpStatus.OK);
    }

    @PostMapping("/bike/add")
    public ResponseEntity<Void> addNewBike(@RequestBody Bike bike) throws CustomException {
        bikeService.addNewBike(bike);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/bike/delete")
    public ResponseEntity<Void> deleteById(@RequestParam Integer id) throws CustomException {
        bikeService.deleteBike(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/bike/update")
    public ResponseEntity<Void> updateById(@RequestParam Integer id,@RequestBody Bike bike) throws CustomException {
        bikeService.updateBikeInfo(id, bike);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
