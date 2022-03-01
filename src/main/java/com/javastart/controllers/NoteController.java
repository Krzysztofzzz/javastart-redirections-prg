package com.javastart.controllers;

import com.javastart.note.Note;
import com.javastart.note.NoteService;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @PostMapping("/save")
    String saveNote(@RequestParam String id, @RequestParam String note, Model model){
        Note noteToSave = new Note(id, note);
        boolean saved = noteService.save(noteToSave);
        if (saved){
            model.addAttribute("note", noteToSave);
            return "note";
        }else {
            return "wrong-data";
        }
    }

    @GetMapping("note")
    String getNote(@RequestParam String id, Model model){
        Optional<Note> note = noteService.findById(id);
        note.ifPresent(n -> model.addAttribute("note",n));
        return "note";
    }
}
