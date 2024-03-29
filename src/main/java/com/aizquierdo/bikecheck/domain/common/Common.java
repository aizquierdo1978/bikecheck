package com.aizquierdo.bikecheck.domain.common;


import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
public class Common implements Serializable {

    @Serial
    private static final long serialVersionUID = 4457999304241268475L;

    private Date creationDate;

    private String creationUser;

    private Date modificationDate;

    private String modificationUser;

    private Date deleteDate;

    private String deleteUser;

}
