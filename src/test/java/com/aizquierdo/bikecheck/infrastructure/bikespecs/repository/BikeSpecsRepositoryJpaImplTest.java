package com.aizquierdo.bikecheck.infrastructure.bikespecs.repository;

import com.aizquierdo.bikecheck.domain.bikespecs.entity.BikeSpecs;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.BikeSpecsEntity;
import com.aizquierdo.bikecheck.infrastructure.bikespecs.mapper.BikeSpecsMapperImpl;
import org.junit.jupiter.api.DisplayName;
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

import static com.aizquierdo.bikecheck.TestConstants.BIKE_ID_1;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BikeSpecsRepositoryJpaImplTest {

    private static final Long BIKE_ID_2 = 2L;

    private static final String CREATION_USER = "userC";

    private static final String MODIFICATION_USER = "userM";

    private static final String DELETION_USER = "userD";

    private static final Long BIKE_PART_1 = 11L;

    private static final Long BIKE_PART_2 = 22L;

    private static final Long BIKE_SPEC_1 = 111L;

    private static final Long BIKE_SPEC_2 = 222L;
    @Spy
    private BikeSpecsMapperImpl bikeSpecsMapper;

    @Mock
    private BikeSpecsCrudRepository bikeSpecsCrudRepository;

    @InjectMocks
    private BikeSpecsRepositoryJpaImpl bikeSpecsRepositoryJpa;

    @DisplayName("findById with existing id should return expected bikeSpecs")
    @Test
    void test_findById_1() {

        // Given
        BikeSpecsEntity bikeSpecsEntity = buildBikeSpecsEntity(BIKE_ID_1, BIKE_PART_1, BIKE_SPEC_1);

        when(this.bikeSpecsCrudRepository.findById(BIKE_ID_1)).thenReturn(Optional.of(bikeSpecsEntity));

        // When
        BikeSpecs bikeSpecs = this.bikeSpecsRepositoryJpa.findById(BIKE_ID_1);

        // Then
        validateBikeSpecs(bikeSpecs, bikeSpecsEntity);
    }

    @DisplayName("create with informed data should return created bikeSpecs")
    @Test
    void test_create_1() {

        // Given
        BikeSpecs bikeSpecs = buildBikeSpecs(null, BIKE_ID_1, BIKE_PART_1);

        BikeSpecsEntity bikeSpecsEntity = buildBikeSpecsEntity(BIKE_SPEC_1, BIKE_ID_1, BIKE_PART_1);

        when(this.bikeSpecsCrudRepository.save(any())).thenReturn(bikeSpecsEntity);

        // When
        BikeSpecs createdBikeSpecs = this.bikeSpecsRepositoryJpa.create(bikeSpecs);

        // Then
        validateBikeSpecs(createdBikeSpecs, bikeSpecsEntity);
    }

    @DisplayName("findAll should return all existing bikespecs")
    @Test
    void test_findAll_1() {

        // Given
        List<BikeSpecsEntity> bikeSpecsEntityList = List.of(buildBikeSpecsEntity(BIKE_SPEC_1, BIKE_ID_1, BIKE_PART_1), buildBikeSpecsEntity(BIKE_SPEC_2, BIKE_ID_2, BIKE_PART_2));

        when(this.bikeSpecsCrudRepository.findAll()).thenReturn(bikeSpecsEntityList);

        // When
        List<BikeSpecs> bikeList = this.bikeSpecsRepositoryJpa.findAll();

        // Then
        assertThat(bikeList)
                .isNotNull()
                .isNotEmpty()
                .hasSameSizeAs(bikeSpecsEntityList);

        IntStream.range(0, bikeList.size()).forEach(i -> validateBikeSpecs(bikeList.get(i), bikeSpecsEntityList.get(i)));

    }

    @DisplayName("update with existing bikeSpecs should return updated bikeSpecs")
    @Test
    void test_update_1() {

        // Given
        BikeSpecs bikeSpecs = buildBikeSpecs(BIKE_SPEC_1, BIKE_ID_2, BIKE_PART_2);

        BikeSpecsEntity bikeSpecsEntity = buildBikeSpecsEntity(BIKE_SPEC_1, BIKE_ID_2, BIKE_PART_2);

        when(this.bikeSpecsCrudRepository.save(any())).thenReturn(bikeSpecsEntity);

        // When
        BikeSpecs updatedBikeSpecs = this.bikeSpecsRepositoryJpa.update(BIKE_SPEC_1, bikeSpecs);

        // Then
        validateBikeSpecs(updatedBikeSpecs, bikeSpecsEntity);
    }

    @DisplayName("delete with existing bikeSpecs should delete bikeSpecs")
    @Test
    void test_delete_1() {

        // Given
        doNothing().when(this.bikeSpecsCrudRepository).deleteById(BIKE_SPEC_1);

        // When
        this.bikeSpecsRepositoryJpa.delete(BIKE_SPEC_1);

        // Then
        verify(this.bikeSpecsCrudRepository, times(1)).deleteById(BIKE_SPEC_1);

    }

    private void validateBikeSpecs(final BikeSpecs bikeSpecs, final BikeSpecsEntity bikeSpecsEntity) {
        assertThat(bikeSpecs).isNotNull();
        assertThat(bikeSpecs.getBikeSpecsId()).isNotNull().isEqualTo(bikeSpecsEntity.getBikeSpecsId());
        assertThat(bikeSpecs.getBikeId()).isNotNull().isEqualTo(bikeSpecsEntity.getBikeId());
        assertThat(bikeSpecs.getBikePartId()).isNotNull().isEqualTo(bikeSpecsEntity.getBikePartId());
        assertThat(bikeSpecs.getCreationDate()).isNotNull().isEqualTo(bikeSpecsEntity.getCreationDate());
        assertThat(bikeSpecs.getCreationUser()).isNotNull().isEqualTo(bikeSpecsEntity.getCreationUser());
        assertThat(bikeSpecs.getModificationDate()).isNotNull().isEqualTo(bikeSpecsEntity.getModificationDate());
        assertThat(bikeSpecs.getModificationUser()).isNotNull().isEqualTo(bikeSpecsEntity.getModificationUser());
        assertThat(bikeSpecs.getDeleteDate()).isNotNull().isEqualTo(bikeSpecsEntity.getDeleteDate());
        assertThat(bikeSpecs.getDeleteUser()).isNotNull().isEqualTo(bikeSpecsEntity.getDeleteUser());
    }

    private BikeSpecsEntity buildBikeSpecsEntity(final Long id, final Long bikeId, Long bikePartId) {
        BikeSpecsEntity bikeSpecsEntity = new BikeSpecsEntity();
        bikeSpecsEntity.setBikeSpecsId(id);
        bikeSpecsEntity.setBikeId(bikeId);
        bikeSpecsEntity.setBikePartId(bikePartId);
        bikeSpecsEntity.setCreationDate(LocalDateTime.now());
        bikeSpecsEntity.setCreationUser(CREATION_USER);
        bikeSpecsEntity.setModificationDate(LocalDateTime.now());
        bikeSpecsEntity.setModificationUser(MODIFICATION_USER);
        bikeSpecsEntity.setDeleteDate(LocalDateTime.now());
        bikeSpecsEntity.setDeleteUser(DELETION_USER);
        return bikeSpecsEntity;
    }

    private BikeSpecs buildBikeSpecs(final Long id, final Long bikeId, Long bikePartId) {
        BikeSpecs bikeSpecs = new BikeSpecs();
        bikeSpecs.setBikeSpecsId(id);
        bikeSpecs.setBikeId(bikeId);
        bikeSpecs.setBikePartId(bikePartId);
        bikeSpecs.setCreationDate(LocalDateTime.now());
        bikeSpecs.setCreationUser(CREATION_USER);
        bikeSpecs.setModificationDate(LocalDateTime.now());
        bikeSpecs.setModificationUser(MODIFICATION_USER);
        bikeSpecs.setDeleteDate(LocalDateTime.now());
        bikeSpecs.setDeleteUser(DELETION_USER);
        return bikeSpecs;
    }
}
