package com.aizquierdo.bikecheck.domain.bikespecs.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BikeSpecs implements Serializable {

    @Serial
    private static final long serialVersionUID = 5683603591623587916L;

    private Long bikeSpecsId;

    private Long bikeId;

    private Long bikePartId;

    private LocalDateTime creationDate;

    private String creationUser;

    private LocalDateTime modificationDate;

    private String modificationUser;

    private LocalDateTime deleteDate;

    private String deleteUser;

}
