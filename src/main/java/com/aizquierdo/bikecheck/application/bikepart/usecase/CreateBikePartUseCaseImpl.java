package com.aizquierdo.bikecheck.application.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.domain.bikepart.repository.BikePartRepository;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.CreateBikePartUseCase;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Transactional
public class CreateBikePartUseCaseImpl implements CreateBikePartUseCase {

    @Autowired
    private BikePartRepository bikePartRepository;

    @Override
    public BikePart execute(BikePart bikePart) {
        bikePart.setCreationDate(LocalDateTime.now());
        return bikePartRepository.create(bikePart);
    }
}
