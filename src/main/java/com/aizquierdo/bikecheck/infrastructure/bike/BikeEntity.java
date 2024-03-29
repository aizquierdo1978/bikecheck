package com.aizquierdo.bikecheck.infrastructure.bike;

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
public class BikeEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = -2596800498077918477L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bikeId;

    private String bikeName;

    private LocalDateTime creationDate;

    private String creationUser;

    private LocalDateTime modificationDate;

    private String modificationUser;

    private LocalDateTime deleteDate;

    private String deleteUser;

    public BikeEntity() {
        super();
    }

    public BikeEntity(Long bikeId) {
        this.bikeId = bikeId;
    }

    public BikeEntity(Long bikeId, String bikeName) {
        this.bikeId = bikeId;
        this.bikeName = bikeName;
    }
}
