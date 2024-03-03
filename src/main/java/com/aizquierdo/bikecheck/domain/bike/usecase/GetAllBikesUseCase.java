package com.aizquierdo.bikecheck.domain.bike.usecase;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;

import java.util.List;

public interface GetAllBikesUseCase {

    List<Bike> execute();
}
