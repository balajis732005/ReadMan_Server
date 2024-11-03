package com.readman.ReadMan_Server.service.note.createNote;

import com.readman.ReadMan_Server.model.NoteCreationRequestModel;
import com.readman.ReadMan_Server.model.ResponseModel;

public interface NoteCreationService {

    ResponseModel<?> noteCreateOperation(NoteCreationRequestModel noteCreationRequestModel);

}
