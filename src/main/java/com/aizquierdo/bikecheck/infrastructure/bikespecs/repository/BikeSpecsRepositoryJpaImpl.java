package com.aizquierdo.bikecheck.infrastructure.bikespecs.repository;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.domain.bikespecs.repository.BikeSpecsRepository;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.BikeSpecsEntity;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.mapper.BikeSpecsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BikeSpecsRepositoryJpaImpl implements BikeSpecsRepository {

    @Autowired
    private BikeSpecsMapper bikeSpecsMapper;

    @Autowired
    private BikeSpecsCrudRepository bikeSpecsCrudRepository;

    @Override
    public BikeSpecs findById(Long bikeSpecsId) {
        Optional<BikeSpecsEntity> bikeSpecs = bikeSpecsCrudRepository.findById(bikeSpecsId);
        return bikeSpecs.map(bikeSpecsEntity -> bikeSpecsMapper.toModel(bikeSpecsEntity)).orElse(null);
    }

    @Override
    public BikeSpecs create(final BikeSpecs bikeSpecs) {
        BikeSpecsEntity entity = bikeSpecsMapper.toEntity(bikeSpecs);
        BikeSpecsEntity createdEntity = bikeSpecsCrudRepository.save(entity);
        return bikeSpecsMapper.toModel(createdEntity);
    }

    @Override
    public List<BikeSpecs> findAll() {
        return bikeSpecsMapper.toModel(bikeSpecsCrudRepository.findAll());
    }

    @Override
    public BikeSpecs update(final Long bikeSpecsId, final BikeSpecs bikeSpecs) {
        BikeSpecsEntity entity = bikeSpecsMapper.toEntity(bikeSpecs);
        BikeSpecsEntity updated = bikeSpecsCrudRepository.save(entity);
        return bikeSpecsMapper.toModel(updated);
    }

    @Override
    public void delete(final Long bikeSpecsId) {
        bikeSpecsCrudRepository.deleteById(bikeSpecsId);
    }


}
