package com.aizquierdo.bikecheck.infrastructure.bikepart.dto;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


public class BikePartDto implements Serializable {

    @Serial
    private static final long serialVersionUID = -6667383568609884295L;

    private Long bikePartId;

    private String bikePartName;

    private LocalDateTime creationDate;

    private String creationUser;

    private LocalDateTime modificationDate;

    private String modificationUser;

    private LocalDateTime deleteDate;

    private String deleteUser;

    public BikePartDto() {
        super();
    }

    public BikePartDto(Long bikePartId) {
        this.bikePartId = bikePartId;
    }

    public BikePartDto(Long bikePartId, String bikePartName) {
        this.bikePartId = bikePartId;
        this.bikePartName = bikePartName;
    }

    public Long getBikeId() {
        return bikePartId;
    }

    public void setBikeId(Long bikePartId) {
        this.bikePartId = bikePartId;
    }

    public String getBikeName() {
        return bikePartName;
    }

    public void setBikeName(String bikePartName) {
        this.bikePartName = bikePartName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(String creationUser) {
        this.creationUser = creationUser;
    }

    public LocalDateTime getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(LocalDateTime modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(String modificationUser) {
        this.modificationUser = modificationUser;
    }

    public LocalDateTime getDeleteDate() {
        return deleteDate;
    }

    public void setDeleteDate(LocalDateTime deleteDate) {
        this.deleteDate = deleteDate;
    }

    public String getDeleteUser() {
        return deleteUser;
    }

    public void setDeleteUser(String deleteUser) {
        this.deleteUser = deleteUser;
    }
}
