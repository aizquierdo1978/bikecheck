package com.aizquierdo.bikecheck.infrastructure.bikepart;

import com.aizquierdo.bikecheck.domain.bikepart.entity.BikePart;
import com.aizquierdo.bikecheck.infrastructure.bikepart.mapper.BikePartMapperImpl;
import com.aizquierdo.bikecheck.infrastructure.bikepart.repository.BikePartCrudRepository;
import com.aizquierdo.bikecheck.infrastructure.bikepart.repository.BikePartRepositoryJpaImpl;
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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class BikePartRepositoryJpaImplTest {

    private static final Long BIKE_PART_ID_1 = 1L;

    private static final Long BIKE_PART_ID_2 = 2L;

    private static final String CREATION_USER = "userC";

    private static final String MODIFICATION_USER = "userM";

    private static final String DELETION_USER = "userD";
    private static final String BIKE_PART_NAME_1 = "bikePartname1";

    private static final String BIKE_PART_NAME_2 = "bikePartname2";
    @Spy
    private BikePartMapperImpl bikePartMapper;

    @Mock
    private BikePartCrudRepository bikePartCrudRepository;

    @InjectMocks
    private BikePartRepositoryJpaImpl bikePartRepositoryJpa;

    @DisplayName("findById with existing id should return expected bikePart")
    @Test
    void test_findById_1() {

        // Given
        BikePartEntity bikePartEntity = buildBikePartEntity(BIKE_PART_ID_1, "bikePartname");

        when(this.bikePartCrudRepository.findById(BIKE_PART_ID_1)).thenReturn(Optional.of(bikePartEntity));

        // When
        BikePart bikePart = this.bikePartRepositoryJpa.findById(BIKE_PART_ID_1);

        // Then
        validateBikePart(bikePart, bikePartEntity);
    }

    @DisplayName("create with informed data should return created bikePart")
    @Test
    void test_create_1() {

        // Given
        BikePart bikePart = buildBikePart(null, BIKE_PART_NAME_1);

        BikePartEntity bikePartEntity = buildBikePartEntity(BIKE_PART_ID_1, BIKE_PART_NAME_1);

        when(this.bikePartCrudRepository.save(any())).thenReturn(bikePartEntity);

        // When
        BikePart createdBikePart = this.bikePartRepositoryJpa.create(bikePart);

        // Then
        validateBikePart(createdBikePart, bikePartEntity);
    }

    @DisplayName("findAll should return all existing bikeParts")
    @Test
    void test_findAll_1() {

        // Given
        List<BikePartEntity> bikePartEntityList = List.of(buildBikePartEntity(BIKE_PART_ID_1, BIKE_PART_NAME_1), buildBikePartEntity(BIKE_PART_ID_2, BIKE_PART_NAME_2));

        when(this.bikePartCrudRepository.findAll()).thenReturn(bikePartEntityList);

        // When
        List<BikePart> bikePartList = this.bikePartRepositoryJpa.findAll();

        // Then
        assertThat(bikePartList)
                .isNotNull()
                .isNotEmpty()
                .hasSameSizeAs(bikePartEntityList);

        IntStream.range(0, bikePartList.size()).forEach(i -> validateBikePart(bikePartList.get(i), bikePartEntityList.get(i)));

    }

    @DisplayName("update with existing bikePart should return updated bikePart")
    @Test
    void test_update_1() {

        // Given
        BikePart bikePart = buildBikePart(BIKE_PART_ID_1, BIKE_PART_NAME_2);

        BikePartEntity bikePartEntity = buildBikePartEntity(BIKE_PART_ID_1, BIKE_PART_NAME_2);

        when(this.bikePartCrudRepository.save(any())).thenReturn(bikePartEntity);

        // When
        BikePart updatedBikePart = this.bikePartRepositoryJpa.update(BIKE_PART_ID_1, bikePart);

        // Then
        validateBikePart(updatedBikePart, bikePartEntity);
    }

    @DisplayName("delete with existing bikePart should delete bikePart")
    @Test
    void test_delete_1() {

        // Given
        doNothing().when(this.bikePartCrudRepository).deleteById(BIKE_PART_ID_1);

        // When
        this.bikePartRepositoryJpa.delete(BIKE_PART_ID_1);

        // Then
        verify(this.bikePartCrudRepository, times(1)).deleteById(BIKE_PART_ID_1);

    }

    private void validateBikePart(final BikePart bikePart, final BikePartEntity bikePartEntity) {
        assertThat(bikePart).isNotNull();
        assertThat(bikePart.getBikePartId()).isNotNull().isEqualTo(bikePartEntity.getBikePartId());
        assertThat(bikePart.getBikePartName()).isNotNull().isEqualTo(bikePartEntity.getBikePartName());
        assertThat(bikePart.getCreationDate()).isNotNull().isEqualTo(bikePartEntity.getCreationDate());
        assertThat(bikePart.getCreationUser()).isNotNull().isEqualTo(bikePartEntity.getCreationUser());
        assertThat(bikePart.getModificationDate()).isNotNull().isEqualTo(bikePartEntity.getModificationDate());
        assertThat(bikePart.getModificationUser()).isNotNull().isEqualTo(bikePartEntity.getModificationUser());
        assertThat(bikePart.getDeleteDate()).isNotNull().isEqualTo(bikePartEntity.getDeleteDate());
        assertThat(bikePart.getDeleteUser()).isNotNull().isEqualTo(bikePartEntity.getDeleteUser());
    }

    private BikePartEntity buildBikePartEntity(final Long id, final String bikePartName) {
        BikePartEntity bikePartEntity = new BikePartEntity();
        bikePartEntity.setBikePartId(id);
        bikePartEntity.setBikePartName(bikePartName);
        bikePartEntity.setCreationDate(LocalDateTime.now());
        bikePartEntity.setCreationUser(CREATION_USER);
        bikePartEntity.setModificationDate(LocalDateTime.now());
        bikePartEntity.setModificationUser(MODIFICATION_USER);
        bikePartEntity.setDeleteDate(LocalDateTime.now());
        bikePartEntity.setDeleteUser(DELETION_USER);
        return bikePartEntity;
    }

    private BikePart buildBikePart(final Long id, final String bikePartName) {
        BikePart bikePart = new BikePart();
        bikePart.setBikePartId(id);
        bikePart.setBikePartName(bikePartName);
        bikePart.setCreationDate(LocalDateTime.now());
        bikePart.setCreationUser(CREATION_USER);
        bikePart.setModificationDate(LocalDateTime.now());
        bikePart.setModificationUser(MODIFICATION_USER);
        bikePart.setDeleteDate(LocalDateTime.now());
        bikePart.setDeleteUser(DELETION_USER);
        return bikePart;
    }
}
