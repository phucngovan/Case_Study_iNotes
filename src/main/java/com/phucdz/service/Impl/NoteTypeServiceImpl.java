package com.phucdz.service.Impl;

import com.phucdz.model.NoteType;
import com.phucdz.repository.NoteTypeRepository;
import com.phucdz.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;

    @Override
    public Iterable<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public NoteType findById(int id) {
        return noteTypeRepository.findOne(id);
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);

    }

    @Override
    public void remove(int id) {
        noteTypeRepository.delete(id);

    }
}
