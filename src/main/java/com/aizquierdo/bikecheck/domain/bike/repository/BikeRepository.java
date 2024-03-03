package com.aizquierdo.bikecheck.domain.bike.repository;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;

import java.util.List;

public interface BikeRepository {

    Bike findById(Long bikeId);

    Bike create(Bike bike);

    List<Bike> findAll();

    Bike update(Long bikeId, Bike bike);

    void delete(Long bikeId);
}
