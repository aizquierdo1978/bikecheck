package com.aizquierdo.bikecheck.domain.bikespecs.usecase;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;

public interface UpdateBikeSpecsUseCase {

    BikeSpecs execute(Long bikeSpecsId, BikeSpecs bikeSpecs);
}
