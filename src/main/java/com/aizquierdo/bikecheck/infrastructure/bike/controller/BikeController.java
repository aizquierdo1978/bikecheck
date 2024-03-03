package com.aizquierdo.bikecheck.infrastructure.bike.controller;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.domain.bike.usecase.CreateBikeUseCase;
import com.aizquierdo.bikecheck.domain.bike.usecase.DeleteBikeUseCase;
import com.aizquierdo.bikecheck.domain.bike.usecase.GetAllBikesUseCase;
import com.aizquierdo.bikecheck.domain.bike.usecase.UpdateBikeUseCase;
import com.aizquierdo.bikecheck.infrastructure.bike.dto.BikeDto;
import com.aizquierdo.bikecheck.infrastructure.bike.mapper.BikeMapper;
import com.aizquierdo.bikecheck.infrastructure.common.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeController extends BaseController {

    private static final Log LOG = LogFactory.getLog(BikeController.class);

    @Autowired
    private CreateBikeUseCase createBikeUseCase;

    @Autowired
    private GetAllBikesUseCase getAllBikesUseCase;

    @Autowired
    private UpdateBikeUseCase updateBikeUseCase;

    @Autowired
    private DeleteBikeUseCase deleteBikeUseCase;

    @Autowired
    private BikeMapper bikeMapper;

    @PostMapping("/bike")
    public ResponseEntity<BikeDto> create(@RequestBody final BikeDto bikeDto) {
        LOG.debug("Starting to create bike : " + bikeDto.toString());
        Bike bike = bikeMapper.toModel(bikeDto);
        Bike createdBike = createBikeUseCase.execute(bike);
        BikeDto createdBikeDto = bikeMapper.toDto(createdBike);
        return new ResponseEntity<>(createdBikeDto, HttpStatus.OK);
    }

    @GetMapping("/bikes")
    public ResponseEntity<List<BikeDto>> findAll() {
        LOG.debug("Starting to get all bikes.");
        List<Bike> allBikes = getAllBikesUseCase.execute();
        return new ResponseEntity<>(bikeMapper.toDtoList(allBikes), HttpStatus.OK);
    }

    @PutMapping("/bike/{id}")
    public ResponseEntity<BikeDto> create(@PathVariable("id") Long bikeId, @RequestBody final BikeDto bikeDto) {
        LOG.debug("Starting to create bike : " + bikeDto.toString());
        Bike bike = bikeMapper.toModel(bikeDto);
        Bike createdBike = updateBikeUseCase.execute(bikeId, bike);
        BikeDto updatedBikeDto = bikeMapper.toDto(createdBike);
        return new ResponseEntity<>(updatedBikeDto, HttpStatus.OK);
    }

    @DeleteMapping("/bike/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long bikeId) {
        LOG.debug("Starting to delete bike with id: " + bikeId);
        deleteBikeUseCase.execute(bikeId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
