package com.aizquierdo.bikecheck.application.bikespecs.usecase;

import com.aizquierdo.bikecheck.domain.bikespecs.repository.BikeSpecsRepository;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.DeleteBikeSpecsUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DeleteBikeSpecsUseCaseImpl implements DeleteBikeSpecsUseCase {

    @Autowired
    private BikeSpecsRepository bikeSpecsRepository;

    @Override
    public void execute(final Long bikeSpecsId) {
        bikeSpecsExists(bikeSpecsId);
        bikeSpecsRepository.delete(bikeSpecsId);
    }

    private void bikeSpecsExists(final Long bikeSpecsId) {
        if (bikeSpecsRepository.findById(bikeSpecsId) == null) {
            throw new EntityNotFoundException("BikeSpecs with id " + bikeSpecsId + " not exists");
        }
    }
}
