package com.aizquierdo.bikecheck.infrastructure.bikepart.repository;

import com.aizquierdo.bikecheck.infrastructure.bikepart.BikePartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BikePartCrudRepository extends JpaRepository<BikePartEntity, Long> {
}
