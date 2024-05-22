package com.aizquierdo.bikecheck.infrastructure.bike.mapper;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.infrastructure.bike.BikeEntity;
import com.aizquierdo.bikecheck.infrastructure.bike.dto.BikeDto;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-04T13:08:01+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class BikeMapperImpl implements BikeMapper {

    @Override
    public BikeDto toDto(Bike bike) {
        if ( bike == null ) {
            return null;
        }

        BikeDto bikeDto = new BikeDto();

        bikeDto.setBikeId( bike.getBikeId() );
        bikeDto.setBikeName( bike.getBikeName() );
        bikeDto.setCreationDate( bike.getCreationDate() );
        bikeDto.setCreationUser( bike.getCreationUser() );
        bikeDto.setModificationDate( bike.getModificationDate() );
        bikeDto.setModificationUser( bike.getModificationUser() );
        bikeDto.setDeleteDate( bike.getDeleteDate() );
        bikeDto.setDeleteUser( bike.getDeleteUser() );

        return bikeDto;
    }

    @Override
    public List<BikeDto> toDtoList(List<Bike> bikes) {
        if ( bikes == null ) {
            return null;
        }

        List<BikeDto> list = new ArrayList<BikeDto>( bikes.size() );
        for ( Bike bike : bikes ) {
            list.add( toDto( bike ) );
        }

        return list;
    }

    @Override
    public Bike toModel(BikeDto bikeDto) {
        if ( bikeDto == null ) {
            return null;
        }

        Bike.BikeBuilder bike = Bike.builder();

        bike.bikeId( bikeDto.getBikeId() );
        bike.bikeName( bikeDto.getBikeName() );
        bike.creationDate( bikeDto.getCreationDate() );
        bike.creationUser( bikeDto.getCreationUser() );
        bike.modificationDate( bikeDto.getModificationDate() );
        bike.modificationUser( bikeDto.getModificationUser() );
        bike.deleteDate( bikeDto.getDeleteDate() );
        bike.deleteUser( bikeDto.getDeleteUser() );

        return bike.build();
    }

    @Override
    public BikeEntity toEntity(Bike bike) {
        if ( bike == null ) {
            return null;
        }

        BikeEntity bikeEntity = new BikeEntity();

        bikeEntity.setBikeId( bike.getBikeId() );
        bikeEntity.setBikeName( bike.getBikeName() );
        bikeEntity.setCreationDate( bike.getCreationDate() );
        bikeEntity.setCreationUser( bike.getCreationUser() );
        bikeEntity.setModificationDate( bike.getModificationDate() );
        bikeEntity.setModificationUser( bike.getModificationUser() );
        bikeEntity.setDeleteDate( bike.getDeleteDate() );
        bikeEntity.setDeleteUser( bike.getDeleteUser() );

        return bikeEntity;
    }

    @Override
    public Bike toModel(BikeEntity bikeEntity) {
        if ( bikeEntity == null ) {
            return null;
        }

        Bike.BikeBuilder bike = Bike.builder();

        bike.bikeId( bikeEntity.getBikeId() );
        bike.bikeName( bikeEntity.getBikeName() );
        bike.creationDate( bikeEntity.getCreationDate() );
        bike.creationUser( bikeEntity.getCreationUser() );
        bike.modificationDate( bikeEntity.getModificationDate() );
        bike.modificationUser( bikeEntity.getModificationUser() );
        bike.deleteDate( bikeEntity.getDeleteDate() );
        bike.deleteUser( bikeEntity.getDeleteUser() );

        return bike.build();
    }

    @Override
    public List<Bike> toModel(List<BikeEntity> bikeEntity) {
        if ( bikeEntity == null ) {
            return null;
        }

        List<Bike> list = new ArrayList<Bike>( bikeEntity.size() );
        for ( BikeEntity bikeEntity1 : bikeEntity ) {
            list.add( toModel( bikeEntity1 ) );
        }

        return list;
    }
}
