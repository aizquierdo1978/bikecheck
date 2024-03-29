package com.aizquierdo.bikecheck.domain.bikepart.usecase;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;

import java.util.List;

public interface GetAllBikePartsUseCase {

    List<BikePart> execute();
}
