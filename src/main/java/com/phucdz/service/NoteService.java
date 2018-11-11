package com.phucdz.service;

import com.phucdz.model.Note;
import com.phucdz.model.NoteType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface NoteService {
    Page<Note> findAll(Pageable pageable);
    Note findById(int id);
    void save(Note note);
    void remove(int id);
    Iterable<Note> findAllByNoteType(NoteType noteType);

    Page<Note> findAllByTitleContaining(String title, Pageable pageable);
}
