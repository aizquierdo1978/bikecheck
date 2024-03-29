package com.aizquierdo.bikecheck.infrastructure.bikepart.repository;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.domain.bikepart.repository.BikePartRepository;
import com.aizquierdo.bikecheck.infrastructure.bikepart.BikePartEntity;
import com.aizquierdo.bikecheck.infrastructure.bikepart.mapper.BikePartMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BikePartRepositoryJpaImpl implements BikePartRepository {

    @Autowired
    private BikePartMapper bikePartMapper;

    @Autowired
    private BikePartCrudRepository bikePartCrudRepository;

    @Override
    public BikePart findById(Long bikePartId) {
        Optional<BikePartEntity> bikePart = bikePartCrudRepository.findById(bikePartId);
        return bikePart.map(bikePartEntity -> bikePartMapper.toModel(bikePartEntity)).orElse(null);
    }

    @Override
    public BikePart create(final BikePart bikePart) {
        BikePartEntity entity = bikePartMapper.toEntity(bikePart);
        BikePartEntity createdEntity = bikePartCrudRepository.save(entity);
        return bikePartMapper.toModel(createdEntity);
    }

    @Override
    public List<BikePart> findAll() {
        return bikePartMapper.toModel(bikePartCrudRepository.findAll());
    }

    @Override
    public BikePart update(final Long bikePartId, final BikePart bikePart) {
        BikePartEntity entity = bikePartMapper.toEntity(bikePart);
        BikePartEntity updated = bikePartCrudRepository.save(entity);
        return bikePartMapper.toModel(updated);
    }

    @Override
    public void delete(final Long bikePartId) {
        bikePartCrudRepository.deleteById(bikePartId);
    }


}
