package com.aizquierdo.bikecheck.infrastructure.bikepart.mapper;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.infrastructure.bikepart.BikePartEntity;
import com.aizquierdo.bikecheck.infrastructure.bikepart.dto.BikePartDto;
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
public class BikePartMapperImpl implements BikePartMapper {

    @Override
    public BikePartDto toDto(BikePart bikePart) {
        if ( bikePart == null ) {
            return null;
        }

        BikePartDto bikePartDto = new BikePartDto();

        bikePartDto.setCreationDate( bikePart.getCreationDate() );
        bikePartDto.setCreationUser( bikePart.getCreationUser() );
        bikePartDto.setModificationDate( bikePart.getModificationDate() );
        bikePartDto.setModificationUser( bikePart.getModificationUser() );
        bikePartDto.setDeleteDate( bikePart.getDeleteDate() );
        bikePartDto.setDeleteUser( bikePart.getDeleteUser() );

        return bikePartDto;
    }

    @Override
    public List<BikePartDto> toDtoList(List<BikePart> bikeParts) {
        if ( bikeParts == null ) {
            return null;
        }

        List<BikePartDto> list = new ArrayList<BikePartDto>( bikeParts.size() );
        for ( BikePart bikePart : bikeParts ) {
            list.add( toDto( bikePart ) );
        }

        return list;
    }

    @Override
    public BikePart toModel(BikePartDto bikePartDto) {
        if ( bikePartDto == null ) {
            return null;
        }

        BikePart.BikePartBuilder bikePart = BikePart.builder();

        bikePart.creationDate( bikePartDto.getCreationDate() );
        bikePart.creationUser( bikePartDto.getCreationUser() );
        bikePart.modificationDate( bikePartDto.getModificationDate() );
        bikePart.modificationUser( bikePartDto.getModificationUser() );
        bikePart.deleteDate( bikePartDto.getDeleteDate() );
        bikePart.deleteUser( bikePartDto.getDeleteUser() );

        return bikePart.build();
    }

    @Override
    public BikePartEntity toEntity(BikePart bikePart) {
        if ( bikePart == null ) {
            return null;
        }

        BikePartEntity bikePartEntity = new BikePartEntity();

        bikePartEntity.setBikePartId( bikePart.getBikePartId() );
        bikePartEntity.setBikePartName( bikePart.getBikePartName() );
        bikePartEntity.setCreationDate( bikePart.getCreationDate() );
        bikePartEntity.setCreationUser( bikePart.getCreationUser() );
        bikePartEntity.setModificationDate( bikePart.getModificationDate() );
        bikePartEntity.setModificationUser( bikePart.getModificationUser() );
        bikePartEntity.setDeleteDate( bikePart.getDeleteDate() );
        bikePartEntity.setDeleteUser( bikePart.getDeleteUser() );

        return bikePartEntity;
    }

    @Override
    public BikePart toModel(BikePartEntity bikePartEntity) {
        if ( bikePartEntity == null ) {
            return null;
        }

        BikePart.BikePartBuilder bikePart = BikePart.builder();

        bikePart.bikePartId( bikePartEntity.getBikePartId() );
        bikePart.bikePartName( bikePartEntity.getBikePartName() );
        bikePart.creationDate( bikePartEntity.getCreationDate() );
        bikePart.creationUser( bikePartEntity.getCreationUser() );
        bikePart.modificationDate( bikePartEntity.getModificationDate() );
        bikePart.modificationUser( bikePartEntity.getModificationUser() );
        bikePart.deleteDate( bikePartEntity.getDeleteDate() );
        bikePart.deleteUser( bikePartEntity.getDeleteUser() );

        return bikePart.build();
    }

    @Override
    public List<BikePart> toModel(List<BikePartEntity> bikePartEntity) {
        if ( bikePartEntity == null ) {
            return null;
        }

        List<BikePart> list = new ArrayList<BikePart>( bikePartEntity.size() );
        for ( BikePartEntity bikePartEntity1 : bikePartEntity ) {
            list.add( toModel( bikePartEntity1 ) );
        }

        return list;
    }
}
