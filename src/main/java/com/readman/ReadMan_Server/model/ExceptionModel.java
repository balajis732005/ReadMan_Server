package com.readman.ReadMan_Server.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionModel {

    private Boolean status;

    private Integer errorHttpStatus;

    private String errorMessage ;

}
