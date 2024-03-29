package com.aizquierdo.bikecheck.application.bikespecs.usecase;

import com.aizquierdo.bikecheck.domain.bike.repository.BikeRepository;
import com.aizquierdo.bikecheck.domain.bikepart.repository.BikePartRepository;
import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.domain.bikespecs.repository.BikeSpecsRepository;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.UpdateBikeSpecsUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import com.aizquierdo.bikecheck.infrastructure.exception.InvalidEntityException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Transactional
public class UpdateBikeSpecsUseCaseImpl implements UpdateBikeSpecsUseCase {

    @Autowired
    private BikeRepository bikeRepository;

    @Autowired
    private BikePartRepository bikePartRepository;

    @Autowired
    private BikeSpecsRepository bikeSpecsRepository;

    @Override
    public BikeSpecs execute(final Long bikeSpecsId, final BikeSpecs bikeSpecs) {
        validateData(bikeSpecsId, bikeSpecs);
        bikeSpecs.setModificationDate(LocalDateTime.now());
        return bikeSpecsRepository.update(bikeSpecsId, bikeSpecs);
    }

    private void validateData(final Long bikeSpecsId, final BikeSpecs bikeSpecs) {
        bikeExists(bikeSpecs.getBikeId());
        bikePartExists(bikeSpecs.getBikePartId());
        bikeSpecsExists(bikeSpecsId);
        if (!bikeSpecsId.equals(bikeSpecs.getBikeSpecsId())) {
            throw new InvalidEntityException("Invalid entity");
        }
    }

    private void bikeSpecsExists(final Long bikeSpecsId) {
        if (bikeSpecsRepository.findById(bikeSpecsId) == null) {
            throw new EntityNotFoundException("BikeSpecs with id " + bikeSpecsId + " not exists");
        }
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
