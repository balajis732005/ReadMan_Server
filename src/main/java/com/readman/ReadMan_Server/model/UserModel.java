package com.readman.ReadMan_Server.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserModel {

    private String userId;

    private String userName;

    private String userEmail;

    private String userPassword;

}
