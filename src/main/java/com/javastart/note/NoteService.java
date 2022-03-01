package com.javastart.note;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class NoteService {
    private final Map<String,Note> notes = new HashMap<>();

    public boolean save(Note note){
        if (notes.containsKey(note.getId())){
            return false;
        }else {
            notes.put(note.getId(), note);
            return true;
        }
    }

    public Optional<Note> findById(String id){
        return Optional.ofNullable(notes.get(id));
    }
}
