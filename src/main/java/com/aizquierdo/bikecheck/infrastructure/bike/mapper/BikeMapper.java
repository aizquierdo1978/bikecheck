package com.aizquierdo.bikecheck.infrastructure.bike.mapper;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.infrastructure.bike.BikeEntity;
import com.aizquierdo.bikecheck.infrastructure.bike.dto.BikeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikeMapper {

    BikeDto toDto(Bike bike);

    List<BikeDto> toDtoList(List<Bike> bikes);

    Bike toModel(BikeDto bikeDto);

    BikeEntity toEntity(Bike bike);

    Bike toModel(BikeEntity bikeEntity);

    List<Bike> toModel(List<BikeEntity> bikeEntity);
}
