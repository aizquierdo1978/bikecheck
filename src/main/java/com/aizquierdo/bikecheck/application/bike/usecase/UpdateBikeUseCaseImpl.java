package com.aizquierdo.bikecheck.application.bike.usecase;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.domain.bike.repository.BikeRepository;
import com.aizquierdo.bikecheck.domain.bike.usecase.UpdateBikeUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import com.aizquierdo.bikecheck.infrastructure.exception.InvalidEntityException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Transactional
public class UpdateBikeUseCaseImpl implements UpdateBikeUseCase {

    @Autowired
    private BikeRepository bikeRepository;

    @Override
    public Bike execute(final Long bikeId, final Bike bike) {
        bikeExists(bikeId);
        if (!bikeId.equals(bike.getBikeId())) {
            throw new InvalidEntityException("Invalid entity");
        }
        bike.setModificationDate(LocalDateTime.now());
        return bikeRepository.update(bikeId, bike);
    }

    private void bikeExists(final Long bikeId) {
        if (bikeRepository.findById(bikeId) == null) {
            throw new EntityNotFoundException(String.format("Bike with id %d not exists", bikeId));
        }
    }
}
