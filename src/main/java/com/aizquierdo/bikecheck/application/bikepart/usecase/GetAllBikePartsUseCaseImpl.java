package com.aizquierdo.bikecheck.application.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.domain.bikepart.repository.BikePartRepository;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.GetAllBikePartsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllBikePartsUseCaseImpl implements GetAllBikePartsUseCase {

    @Autowired
    private BikePartRepository bikePartRepository;

    @Override
    public List<BikePart> execute() {
        return bikePartRepository.findAll();
    }
}
