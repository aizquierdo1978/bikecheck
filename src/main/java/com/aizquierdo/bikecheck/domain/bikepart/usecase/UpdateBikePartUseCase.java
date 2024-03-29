package com.aizquierdo.bikecheck.domain.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;

public interface UpdateBikePartUseCase {

    BikePart execute(Long bikePartId, BikePart bikePart);
}
