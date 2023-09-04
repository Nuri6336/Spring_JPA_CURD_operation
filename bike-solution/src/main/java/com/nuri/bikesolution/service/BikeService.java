package com.nuri.bikesolution.service;

import com.nuri.bikesolution.exception.CustomException;
import com.nuri.bikesolution.model.Bike;
import com.nuri.bikesolution.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeService {
    @Autowired
    private BikeRepository bikeRepository;

    public void addNewBike(Bike bike) throws CustomException {
        if (bikeRepository.findById(bike.getId()).isPresent()){
            throw new CustomException("Already in the store");
        }
        bikeRepository.save(bike);
    }
    public List<Bike> getAllBike(){
        return bikeRepository.findAll();
    }

    public Optional<Bike> getBikeByName(Integer id) throws CustomException {
        if (bikeRepository.findById(id).isEmpty()){
            throw new CustomException("Data is not found");
        }
        return bikeRepository.findById(id);
    }

    public void deleteBike(Integer id) throws CustomException {
        if (bikeRepository.findById(id).isEmpty()){
            throw new CustomException("There is on data with this id");
        }
        bikeRepository.deleteById(id);
    }

    public void updateBikeInfo(Integer id, Bike bike) throws CustomException {
        Bike existingBike = bikeRepository.findById(id)
                .orElseThrow(() -> new CustomException("Data is not stored in database"));

        // Update the fields with the values from the request body
        existingBike.setBikeName(bike.getBikeName());
        existingBike.setBikePrice(bike.getBikePrice());
        existingBike.setBikeQuantity(bike.getBikeQuantity());
        existingBike.setParts(bike.getParts());

        // Save the updated product
        bikeRepository.save(existingBike);
    }
}
