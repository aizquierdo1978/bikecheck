package com.aizquierdo.bikecheck.application.bikespecs.usecase;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.domain.bikespecs.repository.BikeSpecsRepository;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.FindBikeSpecsUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class FindBikeSpecsUseCaseImpl implements FindBikeSpecsUseCase {

    @Autowired
    private BikeSpecsRepository bikeSpecsRepository;

    @Override
    public BikeSpecs execute(final Long bikeSpecsId) {
        return bikeSpecsExists(bikeSpecsId);
    }

    private BikeSpecs bikeSpecsExists(final Long bikeSpecsId) {
        BikeSpecs bikeSpecs = bikeSpecsRepository.findById(bikeSpecsId);
        if (bikeSpecs == null) {
            throw new EntityNotFoundException("BikeSpec with id " + bikeSpecsId + " not exists");
        }
        return bikeSpecs;
    }
}
