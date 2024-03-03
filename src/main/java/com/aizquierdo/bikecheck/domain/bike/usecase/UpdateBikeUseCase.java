package com.aizquierdo.bikecheck.domain.bike.usecase;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;

public interface UpdateBikeUseCase {

    Bike execute(Long bikeId, Bike bike);
}
