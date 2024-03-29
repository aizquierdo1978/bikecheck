package com.aizquierdo.bikecheck.application.bikespecs.usecase;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.domain.bikespecs.repository.BikeSpecsRepository;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.GetAllBikeSpecsUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetAllBikeSpecsUseCaseImpl implements GetAllBikeSpecsUseCase {

    @Autowired
    private BikeSpecsRepository bikeSpecsRepository;

    @Override
    public List<BikeSpecs> execute() {
        return bikeSpecsRepository.findAll();
    }
}
