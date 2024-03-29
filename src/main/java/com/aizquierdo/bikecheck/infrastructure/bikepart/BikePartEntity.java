package com.aizquierdo.bikecheck.infrastructure.bikepart;

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
public class BikePartEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -6788776144906995163L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bikePartId;

    private String bikePartName;

    private LocalDateTime creationDate;

    private String creationUser;

    private LocalDateTime modificationDate;

    private String modificationUser;

    private LocalDateTime deleteDate;

    private String deleteUser;

    public BikePartEntity() {
        super();
    }

    public BikePartEntity(Long bikePartId) {
        this.bikePartId = bikePartId;
    }

    public BikePartEntity(Long bikePartId, String bikePartName) {
        this.bikePartId = bikePartId;
        this.bikePartName = bikePartName;
    }
}
