package com.aizquierdo.bikecheck.infrastructure.repository;

import com.aizquierdo.bikecheck.infrastructure.bike.BikeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikeCrudRepository extends JpaRepository<BikeEntity, Long> {
}
