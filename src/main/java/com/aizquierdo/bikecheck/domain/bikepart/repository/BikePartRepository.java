package com.aizquierdo.bikecheck.domain.bikepart.repository;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;

import java.util.List;

public interface BikePartRepository {

    BikePart findById(Long bikePartId);

    BikePart create(BikePart bikePart);

    List<BikePart> findAll();

    BikePart update(Long bikePartId, BikePart bikePart);

    void delete(Long bikePartId);
}
