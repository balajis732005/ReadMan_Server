package com.readman.ReadMan_Server.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseModel<T> {

    private Boolean status;

    private String message;

    private T data;

}
