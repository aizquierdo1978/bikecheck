package com.aizquierdo.bikecheck.infrastructure.bikespecs.controller;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.CreateBikeSpecsUseCase;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.DeleteBikeSpecsUseCase;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.GetAllBikeSpecsUseCase;
import com.aizquierdo.bikecheck.domain.bikespecs.usecase.UpdateBikeSpecsUseCase;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.dto.BikeSpecsDto;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.mapper.BikeSpecsMapper;
import com.aizquierdo.bikecheck.infrastructure.common.BaseController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BikeSpecsController extends BaseController {

    private static final Log LOG = LogFactory.getLog(BikeSpecsController.class);

    @Autowired
    private CreateBikeSpecsUseCase createBikeSpecsUseCase;

    @Autowired
    private GetAllBikeSpecsUseCase getAllBikeSpecsUseCase;

    @Autowired
    private UpdateBikeSpecsUseCase updateBikeSpecsUseCase;

    @Autowired
    private DeleteBikeSpecsUseCase deleteBikeSpecsUseCase;

    @Autowired
    private BikeSpecsMapper bikeSpecsMapper;

    @PostMapping("/bikespecs")
    public ResponseEntity<BikeSpecsDto> create(@RequestBody final BikeSpecsDto bikeSpecsDto) {
        LOG.debug("Starting to create bikeSpecs : " + bikeSpecsDto.toString());
        BikeSpecs bikeSpecs = bikeSpecsMapper.toModel(bikeSpecsDto);
        BikeSpecs createdBikeSpecs = createBikeSpecsUseCase.execute(bikeSpecs);
        BikeSpecsDto createdBikeSpecsDto = bikeSpecsMapper.toDto(createdBikeSpecs);
        return new ResponseEntity<>(createdBikeSpecsDto, HttpStatus.OK);
    }

    @GetMapping("/bikespecs")
    public ResponseEntity<List<BikeSpecsDto>> findAll() {
        LOG.debug("Starting to get all bikeSpecss.");
        List<BikeSpecs> allBikeSpecs = getAllBikeSpecsUseCase.execute();
        return new ResponseEntity<>(bikeSpecsMapper.toDtoList(allBikeSpecs), HttpStatus.OK);
    }

    @PutMapping("/bikespecs/{id}")
    public ResponseEntity<BikeSpecsDto> create(@PathVariable("id") Long bikeSpecsId, @RequestBody final BikeSpecsDto bikeSpecsDto) {
        LOG.debug("Starting to create bikeSpecs : " + bikeSpecsDto.toString());
        BikeSpecs bikeSpecs = bikeSpecsMapper.toModel(bikeSpecsDto);
        BikeSpecs createdBikeSpecs = updateBikeSpecsUseCase.execute(bikeSpecsId, bikeSpecs);
        BikeSpecsDto updatedBikeSpecsDto = bikeSpecsMapper.toDto(createdBikeSpecs);
        return new ResponseEntity<>(updatedBikeSpecsDto, HttpStatus.OK);
    }

    @DeleteMapping("/bikespecs/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long bikeSpecsId) {
        LOG.debug("Starting to delete bikeSpecs with id: " + bikeSpecsId);
        deleteBikeSpecsUseCase.execute(bikeSpecsId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
