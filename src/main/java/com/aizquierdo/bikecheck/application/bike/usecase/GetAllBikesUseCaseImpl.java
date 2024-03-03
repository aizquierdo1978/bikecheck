package com.aizquierdo.bikecheck.application.bike.usecase;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.domain.bike.repository.BikeRepository;
import com.aizquierdo.bikecheck.domain.bike.usecase.GetAllBikesUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllBikesUseCaseImpl implements GetAllBikesUseCase {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public List<Bike> execute() {
        return bikeRepository.findAll();
    }
}
