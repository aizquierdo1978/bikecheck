package com.aizquierdo.bikecheck.infrastructure.bikepart.mapper;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.infrastructure.bikepart.BikePartEntity;
import com.aizquierdo.bikecheck.infrastructure.bikepart.dto.BikePartDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BikePartMapper {

    BikePartDto toDto(BikePart bikePart);

    List<BikePartDto> toDtoList(List<BikePart> bikeParts);

    BikePart toModel(BikePartDto bikePartDto);

    BikePartEntity toEntity(BikePart bikePart);

    BikePart toModel(BikePartEntity bikePartEntity);

    List<BikePart> toModel(List<BikePartEntity> bikePartEntity);
}
