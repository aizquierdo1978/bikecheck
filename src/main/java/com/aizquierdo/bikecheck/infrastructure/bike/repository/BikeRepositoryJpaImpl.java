package com.aizquierdo.bikecheck.infrastructure.bike.repository;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.domain.bike.repository.BikeRepository;
import com.aizquierdo.bikecheck.infrastructure.bike.BikeEntity;
import com.aizquierdo.bikecheck.infrastructure.bike.mapper.BikeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BikeRepositoryJpaImpl implements BikeRepository {

    @Autowired
    private BikeMapper bikeMapper;

    @Autowired
    private BikeCrudRepository bikeCrudRepository;
    
    @Override
    public Bike findById(Long bikeId) {
        Optional<BikeEntity> bike = bikeCrudRepository.findById(bikeId);
        return bike.map(bikeEntity -> bikeMapper.toModel(bikeEntity)).orElse(null);
    }

    @Override
    public Bike create(final Bike bike) {
        BikeEntity entity = bikeMapper.toEntity(bike);
        BikeEntity createdEntity = bikeCrudRepository.save(entity);
        return bikeMapper.toModel(createdEntity);
    }

    @Override
    public List<Bike> findAll() {
        return bikeMapper.toModel(bikeCrudRepository.findAll());
    }

    @Override
    public Bike update(final Long bikeId, final Bike bike) {
        BikeEntity entity = bikeMapper.toEntity(bike);
        BikeEntity updated = bikeCrudRepository.save(entity);
        return bikeMapper.toModel(updated);
    }

    @Override
    public void delete(final Long bikeId) {
        bikeCrudRepository.deleteById(bikeId);
    }


}
