package com.phucdz.service.Impl;

import com.phucdz.model.Note;
import com.phucdz.model.NoteType;
import com.phucdz.repository.NoteRepository;
import com.phucdz.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteServiceImpl implements NoteService {
    @Autowired
    private NoteRepository noteRepository;


    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findById(int id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);

    }

    @Override
    public void remove(int id) {
        noteRepository.delete(id);

    }

    @Override
    public Iterable<Note> findAllByNoteType(NoteType noteType) {
        return noteRepository.findAllByNoteType(noteType);
    }

    @Override
    public Page<Note> findAllByTitleContaining(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title,pageable);
    }
}
