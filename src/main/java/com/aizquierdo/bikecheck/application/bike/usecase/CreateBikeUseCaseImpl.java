package com.aizquierdo.bikecheck.application.bike.usecase;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.domain.bike.repository.BikeRepository;
import com.aizquierdo.bikecheck.domain.bike.usecase.CreateBikeUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Transactional
public class CreateBikeUseCaseImpl implements CreateBikeUseCase {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public Bike execute(Bike bike) {
        bike.setCreationDate(LocalDateTime.now());
        return bikeRepository.create(bike);
    }
}
