package com.aizquierdo.bikecheck.infrastructure.bikespecs.mapper;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.BikeSpecsEntity;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.dto.BikeSpecsDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikeSpecsMapper {

    BikeSpecsDto toDto(BikeSpecs bikeSpecs);

    List<BikeSpecsDto> toDtoList(List<BikeSpecs> bikeSpecss);

    BikeSpecs toModel(BikeSpecsDto bikeSpecsDto);

    BikeSpecsEntity toEntity(BikeSpecs bikeSpecs);

    BikeSpecs toModel(BikeSpecsEntity bikeSpecsEntity);

    List<BikeSpecs> toModel(List<BikeSpecsEntity> bikeSpecsEntity);
}
