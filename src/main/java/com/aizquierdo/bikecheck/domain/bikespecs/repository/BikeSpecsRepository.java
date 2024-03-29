package com.aizquierdo.bikecheck.domain.bikespecs.repository;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;

import java.util.List;

public interface BikeSpecsRepository {

    BikeSpecs findById(Long bikeSpecsId);

    BikeSpecs create(BikeSpecs bikeSpecs);

    List<BikeSpecs> findAll();

    BikeSpecs update(Long bikeSpecsId, BikeSpecs bikeSpecs);

    void delete(Long bikeSpecsId);
}
