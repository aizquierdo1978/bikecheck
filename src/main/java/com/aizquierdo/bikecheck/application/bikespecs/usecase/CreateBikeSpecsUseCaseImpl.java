package com.aizquierdo.bikecheck.application.bikespecs.usecase;

import com.aizquierdo.bikecheck.domain.bike.repository.BikeRepository;
import com.aizquierdo.bikecheck.domain.bikepart.repository.BikePartRepository;
import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.domain.bikespecs.repository.BikeSpecsRepository;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.CreateBikeSpecsUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Transactional
public class CreateBikeSpecsUseCaseImpl implements CreateBikeSpecsUseCase {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private BikePartRepository bikePartRepository;

    @Autowired
    private BikeSpecsRepository bikeSpecsRepository;

    @Override
    public BikeSpecs execute(BikeSpecs bikeSpecs) {
        validateData(bikeSpecs);
        bikeSpecs.setCreationDate(LocalDateTime.now());
        return bikeSpecsRepository.create(bikeSpecs);
    }

    private void validateData(BikeSpecs bikeSpecs) {
        bikeExists(bikeSpecs.getBikeId());
        bikePartExists(bikeSpecs.getBikePartId());
    }

    private void bikePartExists(final Long bikePartId) {
        if (bikePartRepository.findById(bikePartId) == null) {
            throw new EntityNotFoundException("BikePart with id " + bikePartId + " not exists");
        }
    }

    private void bikeExists(final Long bikeId) {
        if (bikeRepository.findById(bikeId) == null) {
            throw new EntityNotFoundException("Bike with id " + bikeId + " not exists");
        }
    }
}
