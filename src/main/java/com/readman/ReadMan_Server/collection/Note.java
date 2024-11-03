package com.readman.ReadMan_Server.collection;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Builder
@Document(collection = "note")
public class Note {

    @Id
    private String noteId;

    @Field(name = "userId")
    private String userId;

    @Field(name = "noteName")
    private String noteName;

    @Field(name = "noteDescription")
    private String noteDescription;

    @Field(name = "noOfFiles")
    private Integer noOfFiles;

}
