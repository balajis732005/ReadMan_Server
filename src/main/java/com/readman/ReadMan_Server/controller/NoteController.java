package com.readman.ReadMan_Server.controller;

import com.readman.ReadMan_Server.model.NoteCreationRequestModel;
import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.service.note.createNote.NoteCreationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/read-man")
@RequiredArgsConstructor
public class NoteController {

    private final NoteCreationService noteCreationService;

    @PostMapping("/note/create")
    public ResponseEntity<ResponseModel<?>> noteCreateOperation(
            @RequestBody NoteCreationRequestModel noteCreationRequestModel
            ) {
        return ResponseEntity.ok(noteCreationService.noteCreateOperation(noteCreationRequestModel));
    }

}
