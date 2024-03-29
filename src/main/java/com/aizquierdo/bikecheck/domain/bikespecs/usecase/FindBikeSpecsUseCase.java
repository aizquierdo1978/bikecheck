package com.aizquierdo.bikecheck.domain.bikespecs.usecase;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;

public interface FindBikeSpecsUseCase {

    BikeSpecs execute(Long bikeSpecsId);
}
