package com.aizquierdo.bikecheck.domain.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;

public interface CreateBikePartUseCase {

    BikePart execute(BikePart bikePart);
}
