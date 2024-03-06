package com.aizquierdo.bikecheck.infrastructure.bike.repository.BikeRepositoryJpaImplTest;

import com.aizquierdo.bikecheck.domain.bike.entity.Bike;
import com.aizquierdo.bikecheck.infrastructure.bike.BikeEntity;
import com.aizquierdo.bikecheck.infrastructure.bike.mapper.BikeMapperImpl;
import com.aizquierdo.bikecheck.infrastructure.bike.repository.BikeCrudRepository;
import com.aizquierdo.bikecheck.infrastructure.bike.repository.BikeRepositoryJpaImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BikeRepositoryJpaImplTest {

    private static final Long BIKE_ID_1 = 1L;

    private static final Long BIKE_ID_2 = 2L;

    private static final String CREATION_USER = "userC";

    private static final String MODIFICATION_USER = "userM";

    private static final String DELETION_USER = "userD";
    private static final String BIKE_NAME_1 = "bikename1";

    private static final String BIKE_NAME_2 = "bikename2";
    @Spy
    private BikeMapperImpl bikeMapper;

    @Mock
    private BikeCrudRepository bikeCrudRepository;

    @InjectMocks
    private BikeRepositoryJpaImpl bikeRepositoryJpa;

    @Test
    void test_findById_1() {

        // Given
        BikeEntity bikeEntity = buildBikeEntity(BIKE_ID_1, "bikename");

        when(this.bikeCrudRepository.findById(BIKE_ID_1)).thenReturn(Optional.of(bikeEntity));

        // When
        Bike bike = this.bikeRepositoryJpa.findById(BIKE_ID_1);

        // Then
        validateBike(bike, bikeEntity);
    }

    @Test
    void test_create_1() {

        // Given
        Bike bike = buildBike(null, BIKE_NAME_1);

        BikeEntity bikeEntity = buildBikeEntity(BIKE_ID_1, BIKE_NAME_1);

        when(this.bikeCrudRepository.save(any())).thenReturn(bikeEntity);

        // When
        Bike createdBike = this.bikeRepositoryJpa.create(bike);

        // Then
        validateBike(createdBike, bikeEntity);
    }

    @Test
    void test_findAll_1() {

        // Given
        List<BikeEntity> bikeEntityList = List.of(
                buildBikeEntity(BIKE_ID_1, BIKE_NAME_1),
                buildBikeEntity(BIKE_ID_2, BIKE_NAME_2));

        when(this.bikeCrudRepository.findAll()).thenReturn(bikeEntityList);

        // When
        List<Bike> bikeList = this.bikeRepositoryJpa.findAll();

        // Then
        assertThat(bikeList)
                .isNotNull()
                .isNotEmpty()
                .hasSameSizeAs(bikeEntityList);

        IntStream.range(0, bikeList.size()).forEach(i -> validateBike(bikeList.get(i), bikeEntityList.get(i)));

    }

    @Test
    void test_update_1() {

        // Given
        Bike bike = buildBike(BIKE_ID_1, BIKE_NAME_2);

        BikeEntity bikeEntity = buildBikeEntity(BIKE_ID_1, BIKE_NAME_2);

        when(this.bikeCrudRepository.save(any())).thenReturn(bikeEntity);

        // When
        Bike updatedBike = this.bikeRepositoryJpa.update(BIKE_ID_1, bike);

        // Then
        validateBike(updatedBike, bikeEntity);
    }

    @Test
    void test_delete_1() {

        // Given
        Bike bike = buildBike(BIKE_ID_1, BIKE_NAME_2);

        BikeEntity bikeEntity = buildBikeEntity(BIKE_ID_1, BIKE_NAME_2);
        
        doNothing().when(this.bikeCrudRepository).deleteById(BIKE_ID_1);

        // When
        this.bikeRepositoryJpa.delete(BIKE_ID_1);

        // Then
        verify(this.bikeCrudRepository, times(1)).deleteById(BIKE_ID_1);

    }

    private void validateBike(final Bike bike, final BikeEntity bikeEntity) {
        assertThat(bike).isNotNull();
        assertThat(bike.getBikeId()).isNotNull().isEqualTo(bikeEntity.getBikeId());
        assertThat(bike.getBikeName()).isNotNull().isEqualTo(bikeEntity.getBikeName());
        assertThat(bike.getCreationDate()).isNotNull().isEqualTo(bikeEntity.getCreationDate());
        assertThat(bike.getCreationUser()).isNotNull().isEqualTo(bikeEntity.getCreationUser());
        assertThat(bike.getModificationDate()).isNotNull().isEqualTo(bikeEntity.getModificationDate());
        assertThat(bike.getModificationUser()).isNotNull().isEqualTo(bikeEntity.getModificationUser());
        assertThat(bike.getDeleteDate()).isNotNull().isEqualTo(bikeEntity.getDeleteDate());
        assertThat(bike.getDeleteUser()).isNotNull().isEqualTo(bikeEntity.getDeleteUser());
    }

    private BikeEntity buildBikeEntity(final Long id, final String bikeName) {
        BikeEntity bikeEntity = new BikeEntity();
        bikeEntity.setBikeId(id);
        bikeEntity.setBikeName(bikeName);
        bikeEntity.setCreationDate(LocalDateTime.now());
        bikeEntity.setCreationUser(CREATION_USER);
        bikeEntity.setModificationDate(LocalDateTime.now());
        bikeEntity.setModificationUser(MODIFICATION_USER);
        bikeEntity.setDeleteDate(LocalDateTime.now());
        bikeEntity.setDeleteUser(DELETION_USER);
        return bikeEntity;
    }

    private Bike buildBike(final Long id, final String bikeName) {
        Bike bike = new Bike();
        bike.setBikeId(id);
        bike.setBikeName(bikeName);
        bike.setCreationDate(LocalDateTime.now());
        bike.setCreationUser(CREATION_USER);
        bike.setModificationDate(LocalDateTime.now());
        bike.setModificationUser(MODIFICATION_USER);
        bike.setDeleteDate(LocalDateTime.now());
        bike.setDeleteUser(DELETION_USER);
        return bike;
    }
}
