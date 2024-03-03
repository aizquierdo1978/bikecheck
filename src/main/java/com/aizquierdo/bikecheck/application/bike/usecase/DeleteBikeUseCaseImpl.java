package com.aizquierdo.bikecheck.application.bike.usecase;

import com.aizquierdo.bikecheck.domain.bike.repository.BikeRepository;
import com.aizquierdo.bikecheck.domain.bike.usecase.DeleteBikeUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DeleteBikeUseCaseImpl implements DeleteBikeUseCase {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public void execute(final Long bikeId) {
        bikeExists(bikeId);
        bikeRepository.delete(bikeId);
    }

    private void bikeExists(final Long bikeId) {
        if (bikeRepository.findById(bikeId) == null) {
            throw new EntityNotFoundException("Bike with id " + bikeId + " not exists");
        }
    }
}
