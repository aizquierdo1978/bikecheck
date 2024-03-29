package com.aizquierdo.bikecheck.application.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.domain.bikepart.repository.BikePartRepository;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.FindBikePartUseCase;
import com.aizquierdo.bikecheck.infrastructure.exception.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Transactional
public class FindBikePartUseCaseImpl implements FindBikePartUseCase {

    @Autowired
    private BikePartRepository bikePartRepository;

    @Override
    public BikePart execute(final Long bikePartId) {
        return bikePartExists(bikePartId);
    }

    private BikePart bikePartExists(final Long bikePartId) {
        BikePart bikePart = bikePartRepository.findById(bikePartId);
        if (bikePart == null) {
            throw new EntityNotFoundException("Bike with id " + bikePartId + " not exists");
        }
        return bikePart;
    }
}
