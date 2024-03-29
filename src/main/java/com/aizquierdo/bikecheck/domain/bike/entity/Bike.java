package com.aizquierdo.bikecheck.domain.bike.entity;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Bike implements Serializable {

    @Serial
    private static final long serialVersionUID = 1454643248432047118L;

    private Long bikeId;

    private String bikeName;

    private LocalDateTime creationDate;

    private String creationUser;

    private LocalDateTime modificationDate;

    private String modificationUser;

    private LocalDateTime deleteDate;

    private String deleteUser;

    public Bike() {
        super();
    }

    public Bike(String bikeName) {
        super();
        this.bikeName = bikeName;
    }
}
