package com.readman.ReadMan_Server.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NoteCreationRequestModel {

    private String userId;

    private String noteName;

    private String noteDescription;

}
