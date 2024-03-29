package com.aizquierdo.bikecheck.application.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.repository.BikePartRepository;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.DeleteBikePartUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class DeleteBikePartUseCaseImpl implements DeleteBikePartUseCase {

    @Autowired
    private BikePartRepository bikePartRepository;

    @Override
    public void execute(final Long bikePartId) {
        bikePartExists(bikePartId);
        bikePartRepository.delete(bikePartId);
    }

    private void bikePartExists(final Long bikePartId) {
        if (bikePartRepository.findById(bikePartId) == null) {
            throw new EntityNotFoundException("BikePart with id " + bikePartId + " not exists");
        }
    }
}
