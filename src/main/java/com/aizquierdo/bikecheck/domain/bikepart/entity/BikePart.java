package com.aizquierdo.bikecheck.domain.bikepart.entity;

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
public class BikePart implements Serializable {

    @Serial
    private static final long serialVersionUID = -5326215524545454110L;

    private Long bikePartId;

    private String bikePartName;

    private LocalDateTime creationDate;

    private String creationUser;

    private LocalDateTime modificationDate;

    private String modificationUser;

    private LocalDateTime deleteDate;

    private String deleteUser;

}
