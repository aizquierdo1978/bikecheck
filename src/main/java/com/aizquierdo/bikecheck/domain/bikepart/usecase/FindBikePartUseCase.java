package com.aizquierdo.bikecheck.domain.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;

public interface FindBikePartUseCase {

    BikePart execute(Long bikePartId);
}
