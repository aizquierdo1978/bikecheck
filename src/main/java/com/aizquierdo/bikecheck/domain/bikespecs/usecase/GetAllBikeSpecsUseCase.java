package com.aizquierdo.bikecheck.domain.bikespecs.usecase;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;

import java.util.List;

public interface GetAllBikeSpecsUseCase {

    List<BikeSpecs> execute();
}
