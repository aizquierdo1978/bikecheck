package com.aizquierdo.bikecheck.application.bike.usecase;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.domain.bike.repository.BikeRepository;
import com.aizquierdo.bikecheck.domain.bike.usecase.FindBikeUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class FindBikeUseCaseImpl implements FindBikeUseCase {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public Bike execute(final Long bikeId) {
        return bikeExists(bikeId);
    }

    private Bike bikeExists(final Long bikeId) {
        Bike bike = bikeRepository.findById(bikeId);
        if (bike == null) {
            throw new EntityNotFoundException("Bike with id " + bikeId + " not exists");
        }
        return bike;
    }
}
