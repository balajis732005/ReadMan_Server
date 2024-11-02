package com.readman.ReadMan_Server.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document(collection = "user")
public class User {

    @Id
    private String userId;

    @Field(name = "userName")
    private String userName;

    @Field(name = "userEmail")
    private String userEmail;

    @Field(name = "userPassword")
    private String userPassword;

}
