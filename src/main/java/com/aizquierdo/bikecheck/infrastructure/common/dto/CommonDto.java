package com.aizquierdo.bikecheck.infrastructure.common.dto;


import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * La clase CommonDTO.
 */
@Data
@Builder
public class CommonDto implements Serializable {

    private static final long serialVersionUID = 4660877437464343165L;

    private Date creationDate;

    private String creationUser;

    private Date modificationDate;

    private String modificationUser;

    private Date deleteDate;

    private String deleteUser;

}
