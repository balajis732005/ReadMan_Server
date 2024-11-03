package com.readman.ReadMan_Server.repository;

import com.readman.ReadMan_Server.collection.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
}
