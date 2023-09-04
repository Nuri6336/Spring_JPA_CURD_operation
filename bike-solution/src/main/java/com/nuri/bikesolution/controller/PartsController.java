package com.nuri.bikesolution.controller;

import com.nuri.bikesolution.model.Parts;
import com.nuri.bikesolution.service.PartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PartsController {

    @Autowired
    private PartsService partsService;

    @GetMapping("/parts/all")
    public ResponseEntity<List<Parts>> getAllPartsInfo(){
        List<Parts> parts = partsService.getAllParts();
        return new ResponseEntity<>(parts, HttpStatus.OK);
    }

    @GetMapping("/parts/info")
    public ResponseEntity<Parts> getOnePartsInfo(@RequestParam Integer id){
        Optional<Parts> parts = partsService.getPartsByName(id);
        return new ResponseEntity<>(parts.get(), HttpStatus.OK);
    }

    @PostMapping("/parts/add")
    public ResponseEntity<Void> addNewParts(@RequestBody Parts parts){
        partsService.addNewParts(parts);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/parts/delete")
    public ResponseEntity<Void> deleteById(@RequestParam Integer id){
        partsService.deleteParts(id);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PostMapping("/parts/update")
    public ResponseEntity<Void> updateById(@RequestBody Parts parts){
        partsService.updatePartsInfo(parts);
        return new ResponseEntity<>(null, HttpStatus.OK);
    }
}
