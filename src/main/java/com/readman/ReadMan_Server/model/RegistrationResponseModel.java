package com.readman.ReadMan_Server.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationResponseModel {

    private String userId;

    private String peopleName;

    private String userEmail;

}
