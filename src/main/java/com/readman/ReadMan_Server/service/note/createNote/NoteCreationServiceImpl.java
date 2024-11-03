package com.readman.ReadMan_Server.service.note.createNote;

import com.readman.ReadMan_Server.collection.Note;
import com.readman.ReadMan_Server.collection.User;
import com.readman.ReadMan_Server.model.NoteCreationRequestModel;
import com.readman.ReadMan_Server.model.ResponseModel;
import com.readman.ReadMan_Server.repository.NoteRepository;
import com.readman.ReadMan_Server.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class NoteCreationServiceImpl implements NoteCreationService {

    private final UserRepository userRepository;
    private final NoteRepository noteRepository;

    @Override
    public ResponseModel<?> noteCreateOperation(NoteCreationRequestModel noteCreationRequestModel) {

        Optional<User> findUser = userRepository.findById(noteCreationRequestModel.getUserId());

        if(findUser.isEmpty()){
            return ResponseModel.builder()
                    .status(Boolean.FALSE)
                    .message("User Not Found")
                    .data(noteCreationRequestModel)
                    .build();
        }

        Note newNote = Note.builder()
                .userId(noteCreationRequestModel.getUserId())
                .noteName(noteCreationRequestModel.getNoteName())
                .noteDescription(noteCreationRequestModel.getNoteDescription())
                .noOfFiles(0)
                .build();

        Note savedNote = noteRepository.save(newNote);

        return ResponseModel.builder()
                .status(Boolean.TRUE)
                .message("Note Created Successfully")
                .data(savedNote)
                .build();
    }

}
