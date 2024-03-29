package com.aizquierdo.bikecheck.application.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.domain.bikepart.repository.BikePartRepository;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.UpdateBikePartUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import com.aizquierdo.bikecheck.infrastructure.exception.InvalidEntityException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@Transactional
public class UpdateBikePartUseCaseImpl implements UpdateBikePartUseCase {

    @Autowired
    private BikePartRepository bikePartRepository;

    @Override
    public BikePart execute(final Long bikePartId, final BikePart bikePart) {
        bikePartExists(bikePartId);
        if (!bikePartId.equals(bikePart.getBikePartId())) {
            throw new InvalidEntityException("Invalid entity");
        }
        bikePart.setModificationDate(LocalDateTime.now());
        return bikePartRepository.update(bikePartId, bikePart);
    }

    private void bikePartExists(final Long bikePartId) {
        if (bikePartRepository.findById(bikePartId) == null) {
            throw new EntityNotFoundException(String.format("BikePart with id %d not exists", bikePartId));
        }
    }
}
