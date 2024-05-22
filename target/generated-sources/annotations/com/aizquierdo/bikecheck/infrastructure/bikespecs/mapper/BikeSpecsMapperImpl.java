package com.aizquierdo.bikecheck.infrastructure.bikespecs.mapper;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.BikeSpecsEntity;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.dto.BikeSpecsDto;
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
public class BikeSpecsMapperImpl implements BikeSpecsMapper {

    @Override
    public BikeSpecsDto toDto(BikeSpecs bikeSpecs) {
        if ( bikeSpecs == null ) {
            return null;
        }

        BikeSpecsDto bikeSpecsDto = new BikeSpecsDto();

        bikeSpecsDto.setBikeSpecsId( bikeSpecs.getBikeSpecsId() );
        bikeSpecsDto.setBikeId( bikeSpecs.getBikeId() );
        bikeSpecsDto.setBikePartId( bikeSpecs.getBikePartId() );
        bikeSpecsDto.setCreationDate( bikeSpecs.getCreationDate() );
        bikeSpecsDto.setCreationUser( bikeSpecs.getCreationUser() );
        bikeSpecsDto.setModificationDate( bikeSpecs.getModificationDate() );
        bikeSpecsDto.setModificationUser( bikeSpecs.getModificationUser() );
        bikeSpecsDto.setDeleteDate( bikeSpecs.getDeleteDate() );
        bikeSpecsDto.setDeleteUser( bikeSpecs.getDeleteUser() );

        return bikeSpecsDto;
    }

    @Override
    public List<BikeSpecsDto> toDtoList(List<BikeSpecs> bikeSpecss) {
        if ( bikeSpecss == null ) {
            return null;
        }

        List<BikeSpecsDto> list = new ArrayList<BikeSpecsDto>( bikeSpecss.size() );
        for ( BikeSpecs bikeSpecs : bikeSpecss ) {
            list.add( toDto( bikeSpecs ) );
        }

        return list;
    }

    @Override
    public BikeSpecs toModel(BikeSpecsDto bikeSpecsDto) {
        if ( bikeSpecsDto == null ) {
            return null;
        }

        BikeSpecs.BikeSpecsBuilder bikeSpecs = BikeSpecs.builder();

        bikeSpecs.bikeSpecsId( bikeSpecsDto.getBikeSpecsId() );
        bikeSpecs.bikeId( bikeSpecsDto.getBikeId() );
        bikeSpecs.bikePartId( bikeSpecsDto.getBikePartId() );
        bikeSpecs.creationDate( bikeSpecsDto.getCreationDate() );
        bikeSpecs.creationUser( bikeSpecsDto.getCreationUser() );
        bikeSpecs.modificationDate( bikeSpecsDto.getModificationDate() );
        bikeSpecs.modificationUser( bikeSpecsDto.getModificationUser() );
        bikeSpecs.deleteDate( bikeSpecsDto.getDeleteDate() );
        bikeSpecs.deleteUser( bikeSpecsDto.getDeleteUser() );

        return bikeSpecs.build();
    }

    @Override
    public BikeSpecsEntity toEntity(BikeSpecs bikeSpecs) {
        if ( bikeSpecs == null ) {
            return null;
        }

        BikeSpecsEntity bikeSpecsEntity = new BikeSpecsEntity();

        bikeSpecsEntity.setBikeSpecsId( bikeSpecs.getBikeSpecsId() );
        bikeSpecsEntity.setBikeId( bikeSpecs.getBikeId() );
        bikeSpecsEntity.setBikePartId( bikeSpecs.getBikePartId() );
        bikeSpecsEntity.setCreationDate( bikeSpecs.getCreationDate() );
        bikeSpecsEntity.setCreationUser( bikeSpecs.getCreationUser() );
        bikeSpecsEntity.setModificationDate( bikeSpecs.getModificationDate() );
        bikeSpecsEntity.setModificationUser( bikeSpecs.getModificationUser() );
        bikeSpecsEntity.setDeleteDate( bikeSpecs.getDeleteDate() );
        bikeSpecsEntity.setDeleteUser( bikeSpecs.getDeleteUser() );

        return bikeSpecsEntity;
    }

    @Override
    public BikeSpecs toModel(BikeSpecsEntity bikeSpecsEntity) {
        if ( bikeSpecsEntity == null ) {
            return null;
        }

        BikeSpecs.BikeSpecsBuilder bikeSpecs = BikeSpecs.builder();

        bikeSpecs.bikeSpecsId( bikeSpecsEntity.getBikeSpecsId() );
        bikeSpecs.bikeId( bikeSpecsEntity.getBikeId() );
        bikeSpecs.bikePartId( bikeSpecsEntity.getBikePartId() );
        bikeSpecs.creationDate( bikeSpecsEntity.getCreationDate() );
        bikeSpecs.creationUser( bikeSpecsEntity.getCreationUser() );
        bikeSpecs.modificationDate( bikeSpecsEntity.getModificationDate() );
        bikeSpecs.modificationUser( bikeSpecsEntity.getModificationUser() );
        bikeSpecs.deleteDate( bikeSpecsEntity.getDeleteDate() );
        bikeSpecs.deleteUser( bikeSpecsEntity.getDeleteUser() );

        return bikeSpecs.build();
    }

    @Override
    public List<BikeSpecs> toModel(List<BikeSpecsEntity> bikeSpecsEntity) {
        if ( bikeSpecsEntity == null ) {
            return null;
        }

        List<BikeSpecs> list = new ArrayList<BikeSpecs>( bikeSpecsEntity.size() );
        for ( BikeSpecsEntity bikeSpecsEntity1 : bikeSpecsEntity ) {
            list.add( toModel( bikeSpecsEntity1 ) );
        }

        return list;
    }
}
