package com.aizquierdo.bikecheck.infrastructure.bikespecs;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
public class BikeSpecsEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 6930318131185491833L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bikeSpecsId;

    private Long bikeId;

    private Long bikePartId;

    private String bikePartName;

    private LocalDateTime creationDate;

    private String creationUser;

    private LocalDateTime modificationDate;

    private String modificationUser;

    private LocalDateTime deleteDate;

    private String deleteUser;

    public BikeSpecsEntity() {
        super();
    }

    public BikeSpecsEntity(Long bikePartId) {
        this.bikePartId = bikePartId;
    }

    public BikeSpecsEntity(Long bikePartId, String bikePartName) {
        this.bikePartId = bikePartId;
        this.bikePartName = bikePartName;
    }
}
