package com.aizquierdo.bikecheck.infrastructure.bikepart.controller;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.CreateBikePartUseCase;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.DeleteBikePartUseCase;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.GetAllBikePartsUseCase;
import com.aizquierdo.bikecheck.domain.bikepart.usecase.UpdateBikePartUseCase;
import com.aizquierdo.bikecheck.infrastructure.bikepart.dto.BikePartDto;
import com.aizquierdo.bikecheck.infrastructure.bikepart.mapper.BikePartMapper;
import com.aizquierdo.bikecheck.infrastructure.common.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikePartController extends BaseController {

    private static final Log LOG = LogFactory.getLog(BikePartController.class);

    @Autowired
    private CreateBikePartUseCase createBikePartUseCase;

    @Autowired
    private GetAllBikePartsUseCase getAllBikePartsUseCase;

    @Autowired
    private UpdateBikePartUseCase updateBikePartUseCase;

    @Autowired
    private DeleteBikePartUseCase deleteBikePartUseCase;

    @Autowired
    private BikePartMapper bikePartMapper;

    @PostMapping("/bikePart")
    public ResponseEntity<BikePartDto> create(@RequestBody final BikePartDto bikePartDto) {
        LOG.debug("Starting to create bikePart : " + bikePartDto.toString());
        BikePart bikePart = bikePartMapper.toModel(bikePartDto);
        BikePart createdBikePart = createBikePartUseCase.execute(bikePart);
        BikePartDto createdBikePartDto = bikePartMapper.toDto(createdBikePart);
        return new ResponseEntity<>(createdBikePartDto, HttpStatus.OK);
    }

    @GetMapping("/bikeParts")
    public ResponseEntity<List<BikePartDto>> findAll() {
        LOG.debug("Starting to get all bikeParts.");
        List<BikePart> allBikeParts = getAllBikePartsUseCase.execute();
        return new ResponseEntity<>(bikePartMapper.toDtoList(allBikeParts), HttpStatus.OK);
    }

    @PutMapping("/bikePart/{id}")
    public ResponseEntity<BikePartDto> create(@PathVariable("id") Long bikePartId, @RequestBody final BikePartDto bikePartDto) {
        LOG.debug("Starting to create bikePart : " + bikePartDto.toString());
        BikePart bikePart = bikePartMapper.toModel(bikePartDto);
        BikePart createdBikePart = updateBikePartUseCase.execute(bikePartId, bikePart);
        BikePartDto updatedBikePartDto = bikePartMapper.toDto(createdBikePart);
        return new ResponseEntity<>(updatedBikePartDto, HttpStatus.OK);
    }

    @DeleteMapping("/bikePart/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long bikePartId) {
        LOG.debug("Starting to delete bikePart with id: " + bikePartId);
        deleteBikePartUseCase.execute(bikePartId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
