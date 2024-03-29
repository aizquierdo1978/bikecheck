package com.aizquierdo.bikecheck.infrastructure.bikespecs.repository;

import com.aizquierdo.bikecheck.infrastructure.bikespecs.BikeSpecsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeSpecsCrudRepository extends JpaRepository<BikeSpecsEntity, Long> {
}
