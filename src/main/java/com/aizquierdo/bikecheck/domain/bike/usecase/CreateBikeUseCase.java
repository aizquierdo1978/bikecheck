package com.aizquierdo.bikecheck.domain.bike.usecase;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;

public interface CreateBikeUseCase {

    Bike execute(Bike bike);
}
