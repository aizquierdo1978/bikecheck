package com.aizquierdo.bikecheck.infrastructure.bike;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
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

    public Long getBikeId() {
        return bikeId;
    }

    public void setBikeId(Long bikeId) {
        this.bikeId = bikeId;
    }

    public String getBikeName() {
        return bikeName;
    }

    public void setBikeName(String bikeName) {
        this.bikeName = bikeName;
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
