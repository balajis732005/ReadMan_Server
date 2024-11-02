package com.readman.ReadMan_Server.collection;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@Document(collation = "user")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

    @Id
    private String userId;

    private String userName;

    private String userEmail;

    private String userPassword;

}