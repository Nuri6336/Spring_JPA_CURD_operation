package com.nuri.bikesolution.service;

import com.nuri.bikesolution.model.Bike;
import com.nuri.bikesolution.model.Parts;
import com.nuri.bikesolution.repository.PartsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class PartsService {

    @Autowired
    private PartsRepository partsRepository;

    public void addNewParts(@RequestBody Parts parts){
        partsRepository.save(parts);
    }

    public List<Parts> getAllParts(){
        return partsRepository.findAll();
    }

    public Optional<Parts> getPartsByName(Integer id){
        return partsRepository.findById(id);
    }

    public void deleteParts(Integer id){
        partsRepository.deleteById(id);
    }

    public void updatePartsInfo(Parts parts){
        Parts existingParts = partsRepository.findById(parts.getId())
                .orElseThrow(() -> new RuntimeException("Product not found"));

        // Update the fields with the values from the request body
        existingParts.setPartsName(parts.getPartsName());
        existingParts.setPartsPrice(parts.getPartsPrice());
        existingParts.setPartsQuantity(parts.getPartsQuantity());

        // Save the updated product
        partsRepository.save(existingParts);
    }
}
